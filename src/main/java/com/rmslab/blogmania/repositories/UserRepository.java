package com.rmslab.blogmania.repositories;

import com.rmslab.blogmania.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
