package com.godie.Blog.service;

import com.godie.Blog.dto.Post.CreatePostRequestDto;
import com.godie.Blog.dto.Post.PostDto;
import com.godie.Blog.dto.Post.UpdatePostRequestDto;
import com.godie.Blog.model.Post;
import com.godie.Blog.model.User;

import java.util.List;

public interface PostService {
    Post getPost(Long id);

    List<Post> getAllPosts(Long categoryId, Long tagId);

    PostDto createPost(User user, CreatePostRequestDto createPostRequestDto);

    PostDto updatePost(User user, UpdatePostRequestDto updatePostRequestDto);

    void deletePost(Long id);
}

