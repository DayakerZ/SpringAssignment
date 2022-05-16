package com.assignment.root.Assignment.dao;

import com.assignment.root.Assignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUserName(String username);
}
