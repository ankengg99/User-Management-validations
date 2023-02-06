package com.example.management.service;

import com.example.management.module.Management;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

@Service
public class ManagementService {
    // we use list to store info of user
private static  List<Management> list=new ArrayList<Management>();

   static  {
        list.add(new Management(1, "sks12", "sonu", "patna Bihar", "123456789"));
    }

//adding new user
    public void addlist(Management management){
        list.add(management);
    }


    // method for getting all user info
    public List<Management> getAllList(){
        return list;
    }

    // method for getting info of user by their id
    public Management getListById(int id)throws NoSuchElementException {
        Predicate<? super Management> predicate=management -> management.getId()==id;
        return list.stream().filter(predicate).findFirst().get();
    }


    //updating the info of existing user
    public void update(int id,Management management){
        Management temp=getListById(id);
        temp.setAddress(management.getAddress());
        temp.setId(management.getId());
        temp.setName(management.getName());
        temp.setNo(management.getNo());
        temp.setUsername(management.getUsername());
    }


    //deleting the existing user.
    public void delete(int id){
        Predicate<? super Management> predicate=management -> management.getId()==id;
            list.removeIf(predicate);
    }
}
