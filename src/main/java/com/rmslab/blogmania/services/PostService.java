package com.rmslab.blogmania.services;

import com.rmslab.blogmania.dtos.CategoryDto;
import com.rmslab.blogmania.dtos.PostDto;
import com.rmslab.blogmania.dtos.UserDto;
import com.rmslab.blogmania.entities.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    PostDto createPost(PostDto postDto, int userId, int categoryId) ;
    PostDto updatePost(PostDto postDto, int postId) ;
    List<PostDto> getAllPosts() ;
    PostDto getPostById(int postId) ;
    void deletePost(int postId) ;
    List<PostDto> findPostByKeyword(String keyword) ;
    List<PostDto> findPostByUser(int userId) ;
    List<PostDto> findPostByCategory(int categoryId) ;
}
