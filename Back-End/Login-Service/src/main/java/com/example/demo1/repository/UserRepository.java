package com.example.demo1.repository;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
 Optional<User> findByUserName(String userName);
}
