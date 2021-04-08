package com.aboda.FriendFinder.repository;

import com.aboda.FriendFinder.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend,Integer> {

    public List<Friend> findByid(Integer id);

    public List<Friend> findByidFriend(int idFriend);

}
