package com.aboda.FriendFinder.controller;

import com.aboda.FriendFinder.model.Comment;
import com.aboda.FriendFinder.model.Friend;
import com.aboda.FriendFinder.model.Post;
import com.aboda.FriendFinder.repository.CommentInterface;
import com.aboda.FriendFinder.service.CommentService;
import com.aboda.FriendFinder.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    CommentInterface commentInterface;

    @GetMapping("/postss/{post}")
    public List<Comment> getFriendsBrFriendId(@PathVariable("post") int post){
        return commentService.findPostsby(post);

    }


    @PostMapping("/postss/comments/add")
    public ResponseEntity<?> addPosts(@RequestBody Comment comment){
        return new ResponseEntity<>( this.commentInterface.save(comment), HttpStatus.CREATED);


    }


}
