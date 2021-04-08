package com.aboda.FriendFinder.repository;

import com.aboda.FriendFinder.model.Userfriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserfriendRepository extends JpaRepository<Userfriend,Integer> {

}
