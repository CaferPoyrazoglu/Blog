package com.godie.Blog.service;

import com.godie.Blog.dto.Post.CreatePostRequestDto;
import com.godie.Blog.dto.Post.PostDto;
import com.godie.Blog.model.User;

import java.util.List;

public interface PostService {
    PostDto createPost(CreatePostRequestDto createPostRequestDto, User user);

    void deletePostById(Long id, User user);

    PostDto getPostById(Long id);

    List<PostDto> getPosts();

    Long calculateReadingTime(String text);
}

