package com.godie.Blog.service;

import com.godie.Blog.dto.Post.CreatePostRequestDto;
import com.godie.Blog.dto.Post.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(CreatePostRequestDto createPostRequestDto);

    void deletePost(Long id);

    PostDto getPost(Long id);

    List<PostDto> getAllPosts();
}

