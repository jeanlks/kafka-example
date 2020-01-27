package com.user.usertest.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/list")
    public ResponseEntity<User> getUser (){
        return ResponseEntity.ok(new User("Jean", 26));
    }

}