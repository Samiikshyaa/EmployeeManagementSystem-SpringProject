package com.bway.springproject.repository;

import com.bway.springproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
        User findByEmailAndPassword(String email, String password);

}
