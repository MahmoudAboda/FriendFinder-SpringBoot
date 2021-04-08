package com.aboda.FriendFinder.repository;

import com.aboda.FriendFinder.model.Comment;
import com.aboda.FriendFinder.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentInterface extends JpaRepository<Comment,Integer> {




    @Query(value = " select * from comments\n" +
            "    where postid=?;",nativeQuery = true)
    public List<Comment> commentFindings(int post );

}
