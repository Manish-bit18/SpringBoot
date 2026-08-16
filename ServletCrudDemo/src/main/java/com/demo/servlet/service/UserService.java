package com.demo.servlet.service;

import com.demo.servlet.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserService  {

    HashMap<Integer , User> userDB;

    public UserService(){
        userDB = new HashMap<>();
    }

    public User createUser(User userReq){
        userDB.put(userReq.getId() , userReq);

        return userReq;
    }

    public List<User> getAllUser(){
       List<User> userResp = new ArrayList<>();

       for(User user : userDB.values()){
           userResp.add(user);
       }
       return userResp;
    }

    public User getUserById(Integer id){
        return userDB.getOrDefault(id , null);
    }

}

