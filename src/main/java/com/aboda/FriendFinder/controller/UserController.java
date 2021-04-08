package com.aboda.FriendFinder.controller;

import com.aboda.FriendFinder.model.Post;
import com.aboda.FriendFinder.model.User;
import com.aboda.FriendFinder.repository.PostRepository;
import com.aboda.FriendFinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;
    //Get All Clients
    @GetMapping("/users")
    public List<User> findAll(){
        return this.userRepository.findAll();
    }


}
