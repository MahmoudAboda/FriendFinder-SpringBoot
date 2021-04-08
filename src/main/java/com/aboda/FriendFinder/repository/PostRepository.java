package com.aboda.FriendFinder.repository;

import com.aboda.FriendFinder.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {


    @Query(value = "Select * From posts",nativeQuery = true)
   public List<Post> postFinding();


    @Query(value = "SELECT * FROM posts s\n" +
            "  INNER JOIN friends  sc ON s.id = sc.friend_id\n" +
            "  INNER JOIN user c ON sc.user_id = c.id\n" +
            "WHERE s.user_id = ?",nativeQuery = true)
    public List<Post> postFindings(Integer id);

}
