package com.godie.Blog.service;

import com.godie.Blog.dto.Post.CreatePostRequestDto;
import com.godie.Blog.dto.Post.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(CreatePostRequestDto createPostRequestDto);

    void deletePostById(Long id);

    PostDto getPostById(Long id);

    List<PostDto> getPosts();
}

