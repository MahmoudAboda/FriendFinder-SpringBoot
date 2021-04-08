package com.aboda.FriendFinder.service;

import com.aboda.FriendFinder.controller.RegistrationController;
import com.aboda.FriendFinder.model.User;
import com.aboda.FriendFinder.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository repo;

    public User saveUser(User user){
       return repo.save(user);
    }
    public User fetchUserByEmail(String email){
      return   repo.findByEmail(email);
    }
    public User fetchUserByEmailAndPassword(String email ,String password)
    {return repo.findByEmailAndPassword(email,password);}
}
