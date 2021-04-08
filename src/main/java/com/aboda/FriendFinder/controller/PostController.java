package com.aboda.FriendFinder.controller;

import com.aboda.FriendFinder.model.Post;
import com.aboda.FriendFinder.repository.PostRepository;
import com.aboda.FriendFinder.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    PostRepository postRepository;
    //Get All Clients
    @GetMapping("/posts")
    public List<Post> findAll(){
        return this.postService.findAll();
    }


    @GetMapping("/finding")
    public List<Post> findAllposts( ){
        return this.postService.findPosts();
    }


    @GetMapping("/findingall/{id}")
    public List<Post> findAllpostss(@PathVariable("id") Integer id ){
        return this.postService.findPostsby(id);
    }

    @PostMapping("/posts/add")
    public ResponseEntity<?> addPosts(@RequestBody Post post){
        return new ResponseEntity<>( this.postRepository.save(post),HttpStatus.CREATED);


    }

    @PostMapping("/posts/add1")
    public void savePost(@RequestParam("image")MultipartFile image,
                         @RequestParam("likes")int likes,
                         @RequestParam("text")String text
                         )
    {postService.savePostToDB(image,text,likes);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Integer id,@RequestBody Post post){
        if(this.postRepository.findById(id).isPresent()){
            post.setId(id);
            return new ResponseEntity<>(this.postRepository.save(post),HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id ){
        if(this.postRepository.findById(id).isPresent()){
            return new ResponseEntity<>(this.postRepository.findById(id),HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
