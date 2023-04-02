package com.rmslab.blogmania.services;

import com.rmslab.blogmania.dtos.CategoryDto;
import com.rmslab.blogmania.dtos.PostDto;
import com.rmslab.blogmania.dtos.UserDto;
import com.rmslab.blogmania.entities.Category;
import com.rmslab.blogmania.entities.Post;
import com.rmslab.blogmania.entities.User;
import com.rmslab.blogmania.exceptions.ResourceNotFoundException;
import com.rmslab.blogmania.repositories.CategoryRepository;
import com.rmslab.blogmania.repositories.PostRepository;
import com.rmslab.blogmania.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired private PostRepository postRepository ;
    @Autowired private UserRepository userRepository ;
    @Autowired private CategoryRepository categoryRepository ;
    @Autowired ModelMapper modelMapper ;

    private PostDto postToDto(Post post) {
        return modelMapper.map(post, PostDto.class) ;
    }

    private Post postDtoToPost(PostDto postDto) {
        return modelMapper.map(postDto, Post.class) ;
    }

    @Override
    public PostDto createPost(PostDto postDto, int userId, int categoryId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId)) ;
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Id",categoryId)) ;
        Post post = postDtoToPost(postDto) ;
        post.setImageUrl("profile-pic.png");
        post.setDateOfPost(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post createdPost = postRepository.save(post) ;
        return postToDto(createdPost) ;
    }

    @Override
    public PostDto updatePost(PostDto postDto, int postId) {
        return null;
    }

    @Override
    public List<PostDto> getAllPosts() {
        return null;
    }

    @Override
    public PostDto getPostById(int postId) {
        return null;
    }

    @Override
    public void deletePost(int postId) {

    }

    @Override
    public List<PostDto> findPostByKeyword(String keyword) {
        return null;
    }

    @Override
    public List<PostDto> findPostByUser(int userId) {
        return null;
    }

    @Override
    public List<PostDto> findPostByCategory(int categoryId) {
        return null;
    }
}
