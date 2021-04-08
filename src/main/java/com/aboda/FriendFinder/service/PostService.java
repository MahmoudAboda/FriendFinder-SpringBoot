package com.aboda.FriendFinder.service;

import com.aboda.FriendFinder.model.Post;
import com.aboda.FriendFinder.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<Post> findAll() {
        return this.postRepository.findAll();
    }


    public List<Post> findPosts() {
        return this.postRepository.postFinding();
    }

    public List<Post> findPostsby(Integer id) {
        return this.postRepository.postFindings(id);
    }

    public void savePostToDB(MultipartFile file, String text, int likes) {


    Post p = new Post();
   String fileName= StringUtils.cleanPath(file.getOriginalFilename());
   if(fileName.contains("..")){
       System.out.println("not a Valid file");
   }
        try {
            p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.setLike(likes);
        p.setText(text);
        postRepository.save(p);


}

}
