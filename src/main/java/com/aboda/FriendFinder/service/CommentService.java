package com.aboda.FriendFinder.service;

import com.aboda.FriendFinder.model.Comment;
import com.aboda.FriendFinder.model.Post;
import com.aboda.FriendFinder.repository.CommentInterface;
import com.aboda.FriendFinder.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentInterface commentInterface;


        public List<Comment> findPostsby(int post ){
            return this.commentInterface.commentFindings(post);
        }
    }

