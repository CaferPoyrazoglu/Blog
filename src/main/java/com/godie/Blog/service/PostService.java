package com.godie.Blog.service;

import com.godie.Blog.dto.Post.CreatePostRequestDto;
import com.godie.Blog.model.Post;

import java.util.List;

public interface PostService {
    Post createPost(CreatePostRequestDto createPostRequestDto);

    void deletePost(Long id);

    Post getPost(Long id);

    List<Post> getAllPosts();
}

