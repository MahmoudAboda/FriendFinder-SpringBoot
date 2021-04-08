package com.aboda.FriendFinder.controller;

import com.aboda.FriendFinder.model.Friend;
import com.aboda.FriendFinder.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class FriendController {

    @Autowired
    FriendService friendService;
    //Get All Clients


    @GetMapping("/friends/{id}")
    public List<Friend> getFriendsBrFriendId(@PathVariable("id") Integer id){
       return friendService.getFriendsById(id);

    }

    @GetMapping("/friend/{idFriend}")
    public List<Friend> getFriendsBrFriendIds(@PathVariable("idFriend") int idFriend){
        return friendService.getFriendsByidFriend(idFriend);


    }
    @PostMapping("/addfriend")
        public String addEmp(@RequestBody Friend newFriend) {
            friendService.addEmp(newFriend);
            return "saved success";
        }
        }






