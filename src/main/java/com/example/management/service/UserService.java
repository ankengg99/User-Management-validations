package com.example.management.service;

import com.example.management.dao.UserRepository;
import com.example.management.moudle.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public void addUser(User user){
        userRepository.save(user);
    }
    public List<User> getUser(Integer id){
        if(null!=id){
            List<User> user=new ArrayList<>();
            user.add(userRepository.findById(id).get());
            return user;
        }
        else{
            return userRepository.findAll();
        }
    }
    public void updateUser(Integer id,User newuser){
        User user=userRepository.findById(id).get();
        user.setDate(newuser.getDate());
        user.setEmail(newuser.getEmail());
        user.setTime(newuser.getTime());
        user.setPhoneNo(newuser.getPhoneNo());
        user.setDateOfBirth(newuser.getDateOfBirth());
        user.setUsername(newuser.getUsername());
        userRepository.save(user);
    }
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
    public User setUser(JSONObject jsonObject){
        User user=new User();
        user.setUserId(jsonObject.getInt("userId"));
        user.setDate(LocalDate.ofEpochDay(jsonObject.getInt("date")));
        user.setTime(LocalTime.ofSecondOfDay(jsonObject.getInt("time")));
        user.setEmail(jsonObject.getString("email"));
        user.setUsername(jsonObject.getString("userName"));
        user.setPhoneNo(jsonObject.getString("phoneNo"));
        user.setDateOfBirth(jsonObject.getString("dateOfBirth"));
        return user;
    }
}
