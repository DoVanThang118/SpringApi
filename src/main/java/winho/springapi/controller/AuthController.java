package winho.springapi.controller;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import winho.springapi.config.jwts.JwtUtil;
import winho.springapi.model.dto.UserDto;
import winho.springapi.model.request.AuthReq;
import winho.springapi.model.request.CreateUserReq;
import winho.springapi.model.response.AuthRes;
import winho.springapi.service.impl.UserDetailsServiceImpl;
import winho.springapi.service.UserService;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody CreateUserReq createUserReq) {
        UserDto create = userService.createUser(createUserReq);
        if (create == null) return new ResponseEntity<>("User is not created, try again later", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    @PostMapping("/auth")
    public AuthRes createAuthToken(@RequestBody AuthReq authReq, HttpServletResponse response) throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException, java.io.IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authReq.getEmail(), authReq.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Tên đăng nhập hoặc mật khẩu không chính xác!");
        } catch (DisabledException disabledException) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Người dùng chưa được kích hoạt");
            return null;
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authReq.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        return new AuthRes(jwt);
    }
}
