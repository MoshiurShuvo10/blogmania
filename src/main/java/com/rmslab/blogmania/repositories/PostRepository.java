package com.rmslab.blogmania.repositories;

import com.rmslab.blogmania.entities.Category;
import com.rmslab.blogmania.entities.Post;
import com.rmslab.blogmania.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user) ;
    List<Post> findByCategory(Category category) ;

}
