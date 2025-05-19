package com.godie.Blog.service;

import com.godie.Blog.dto.Post.CreatePostRequestDto;
import com.godie.Blog.dto.Post.PostDto;

public interface PostService {
    PostDto createPost(CreatePostRequestDto createPostRequestDto);
}

