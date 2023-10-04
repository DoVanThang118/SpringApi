package winho.springapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import winho.springapi.model.dto.UserDto;
import winho.springapi.model.request.CreateUserReq;
import winho.springapi.model.request.UpdateUserReq;
import winho.springapi.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getUser() {
        List<UserDto> users = userService.getUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findId(@PathVariable int id) {
        UserDto result = userService.findId(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam(value = "keyword", required = false, defaultValue = "") String name) {
        List<UserDto> users = userService.searchUser(name);
        return ResponseEntity.ok(users);
    }

//    @PostMapping("")
//    public ResponseEntity<?> createUser(@RequestBody CreateUserReq req) {
//        UserDto result = userService.createUser(req);
//        return ResponseEntity.ok(result);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserReq req, @PathVariable int id) {
        UserDto result = userService.updateUser(req, id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Delete Success");
    }
}