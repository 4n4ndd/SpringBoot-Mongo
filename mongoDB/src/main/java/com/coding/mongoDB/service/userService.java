package com.coding.mongoDB.service;

import com.coding.mongoDB.model.UserDetails;
import com.coding.mongoDB.repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    @Autowired
    private userRepo userRepo;

    public userService(userRepo userRepo) {
        this.userRepo = userRepo;
    }

    public  UserDetails createUser(UserDetails userDetails) {
       return userRepo.save(userDetails);

    }

    public List<UserDetails> getAllUsers() {
        return userRepo.findAll();
    }

    public UserDetails updateUser(String id, UserDetails userDetails) {
        UserDetails existingUser = userRepo.findById(id).orElseThrow(()->new RuntimeException("User Not found"));
        existingUser.setName(userDetails.getName());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setAge(userDetails.getAge());
        return userRepo.save(existingUser);
    }

    public boolean deleteUser(String id) {
        if(!userRepo.existsById(id)){
            throw new RuntimeException("User not found");
        }
        userRepo.deleteById(id);
        return true;
    }
}
