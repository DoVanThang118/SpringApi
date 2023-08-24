package winho.springapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import winho.springapi.entity.User;
import winho.springapi.model.dto.UserDto;
import winho.springapi.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getUser(){
        List<UserDto> users = userService.getUser();
        return ResponseEntity.ok(users);
    }

    @PostMapping("")
    public ResponseEntity<?> createUser(){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(){
        return null;
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteUser(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findId(@PathVariable int id){
        UserDto result = userService.findId(id);
        return ResponseEntity.ok(result);
    }
}
