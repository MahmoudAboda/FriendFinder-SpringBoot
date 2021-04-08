package com.aboda.FriendFinder.service;

import com.aboda.FriendFinder.model.Friend;
import com.aboda.FriendFinder.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService  {

    @Autowired
    FriendRepository friendRepository;

    public List<Friend> getFriendsById(Integer id) {
        return  friendRepository.findByid(id);
    }

    public List<Friend> getFriendsByidFriend(int idFriend) {
        return  friendRepository.findByidFriend(idFriend);
    }

    public void addEmp(Friend friend){
        friendRepository.save(friend);
    }
}
