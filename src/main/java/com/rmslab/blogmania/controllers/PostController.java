package com.rmslab.blogmania.controllers;

import com.rmslab.blogmania.dtos.PostDto;
import com.rmslab.blogmania.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired private PostService postService ;

    @PostMapping("/user/{userId}/category/{categoryId}")
    public ResponseEntity<PostDto> createPost
            (@RequestBody PostDto postDto, @PathVariable int userId, @PathVariable int categoryId) {
        PostDto createdPost = postService.createPost(postDto, userId, categoryId) ;
        return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED) ;
    }
}
