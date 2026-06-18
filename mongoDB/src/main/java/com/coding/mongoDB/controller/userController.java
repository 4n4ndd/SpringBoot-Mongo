package com.coding.mongoDB.controller;

import com.coding.mongoDB.model.UserDetails;
import com.coding.mongoDB.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/mongo")
public class userController {
    @Autowired
    private userService userService;

    public userController(userService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDetails> createUser(@RequestBody UserDetails userDetails){
        UserDetails createdUser = userService.createUser(userDetails);
        return ResponseEntity.ok(createdUser);
    }
    @GetMapping
    public List<UserDetails> getUsers(){
        return userService.getAllUsers();
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDetails> updateUsers(@PathVariable String id, @RequestBody UserDetails userDetails){
        UserDetails updatedUser = userService.updateUser(id,userDetails);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/{id}")
    public String deleteUsers(@PathVariable String id){
        boolean isDeleted = userService.deleteUser(id);
        if(!isDeleted){
            return "Error";
        }
        return "User deleted";
    }
}
