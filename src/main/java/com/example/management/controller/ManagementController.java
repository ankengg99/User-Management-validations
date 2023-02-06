package com.example.management.controller;

import com.example.management.module.Management;
import com.example.management.service.ManagementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/management-app")
public class ManagementController {
ManagementService managementService;
// Creating object of service layer
ManagementController(ManagementService managementService){
    this.managementService=managementService;
}


//method of acessing all user
    //localhost:8080/user/management-app/get-all-user
@GetMapping("/get-all-user")
    public List<Management> getAllUser(){
    return managementService.getAllList();
}


//method for acess user by user id
    //localhost:8080/user/management-app/get-user/userid
@GetMapping("/get-user/{userid}")
    public Management getUser(@PathVariable int userid){
    return managementService.getListById(userid);
}


//method for adding new user
    //localhost:8080/user/management-app/add-user
@PostMapping("/add-user")
public void addUser(@RequestBody Management management){
    managementService.addlist(management);
}


//method for update info of existing user by userid
    //localhost:8080/user/management-app/update/user-info/userid
@PutMapping("/update/user-info/{userid}")
    public void updateUser(@PathVariable int userid,@RequestBody Management management){
    managementService.update(userid,management);
}


//method for delete existing user by userid
    //localhost:8080/user/management-app/delete-user/userid
@DeleteMapping("/delete-user/{userid}")
    public void deleteUser(@PathVariable int userid){
    managementService.delete(userid);
}
}
