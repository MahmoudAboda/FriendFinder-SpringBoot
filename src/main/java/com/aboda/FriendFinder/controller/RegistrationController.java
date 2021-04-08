package com.aboda.FriendFinder.controller;

import com.aboda.FriendFinder.model.User;
import com.aboda.FriendFinder.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;

@RestController
public class RegistrationController  {

    @Autowired
    private RegistrationService service;

    @PostMapping("/registeruser")
    @CrossOrigin(origins ="localhost:4200")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmail=user.getEmail();
        if(tempEmail !=null && !"".equals(tempEmail)){
            User userObj=service.fetchUserByEmail(tempEmail);
            if(userObj !=null){
                throw  new Exception("user with "+tempEmail+"is alreadr Exists");
            }

        }

        User userObj=null;
        userObj=service.saveUser(user);
        return userObj;
    }
    @PostMapping("/login")
    @CrossOrigin(origins ="localhost:4200")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmail=user.getEmail();
        String tempPass=user.getPassword();
        User userObj=null;
        if(tempEmail !=null && tempPass !=null){
            userObj=service.fetchUserByEmailAndPassword(tempEmail,tempPass);
        }
        if(userObj ==null){
            throw new Exception("Bad credentials");
        }
        return userObj;

    }
    }

