package com.example.management.controller;

import com.example.management.utils.UserValidator;
import com.example.management.moudle.User;
import com.example.management.service.UserService;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/app/v1")
public class UserController {
 @Autowired
    UserService service;
 @Autowired
    UserValidator validator;
 @PostMapping("/add-user")
    public ResponseEntity addUser( @RequestBody String user){
     JSONObject jsonObject=new JSONObject(user);

     List<String> valid=validator.isValidUser(jsonObject);
     if(valid.isEmpty()){
         User newUser=service.setUser(jsonObject);
         service.addUser(newUser);
         return new ResponseEntity<>("user saved", HttpStatus.CREATED);
     }
     String[] answer = Arrays.copyOf(
             valid.toArray(), valid.size(), String[].class);

     return new ResponseEntity<>("Please pass these mandatory parameters- " +
             Arrays.toString(answer), HttpStatus.BAD_REQUEST);
 }
    @GetMapping("/get-user")
    public List<User> getUser(@Nullable @RequestParam Integer id){
     return service.getUser(id);
    }
    @PutMapping("/update-user")
    public ResponseEntity updateUser(@RequestParam Integer id,@RequestBody String user){
        JSONObject jsonObject=new JSONObject(user);

        List<String> valid=validator.isValidUser(jsonObject);
        if(valid.isEmpty()){
            User newUser=service.setUser(jsonObject);
            service.updateUser(id,newUser);
            return new ResponseEntity<>("user saved", HttpStatus.CREATED);
        }
        String[] answer = Arrays.copyOf(
                valid.toArray(), valid.size(), String[].class);

        return new ResponseEntity<>("Please pass these mandatory parameters- " +
                Arrays.toString(answer), HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/delete-user")
     public String deleteUser(@RequestParam Integer id){
     service.deleteUser(id);
     return "user deleted";
    }

}
