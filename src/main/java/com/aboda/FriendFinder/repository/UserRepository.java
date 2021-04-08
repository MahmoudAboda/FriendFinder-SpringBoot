package com.aboda.FriendFinder.repository;

import com.aboda.FriendFinder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
