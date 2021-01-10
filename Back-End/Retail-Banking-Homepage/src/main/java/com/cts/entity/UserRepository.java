package com.cts.entity;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
 
}
