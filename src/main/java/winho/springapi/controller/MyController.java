package winho.springapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import winho.springapi.User;

@RestController
public class MyController {
    @RequestMapping(value = "demo", method = RequestMethod.GET)
    public ResponseEntity<?> demo(){
        User user = new User(1,"Boss A");
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
