package com.godie.Blog.service;

import com.godie.Blog.dto.Post.CreatePostRequestDto;
import com.godie.Blog.dto.Post.PostDto;
import com.godie.Blog.dto.Post.PostWithoutStoryDto;
import com.godie.Blog.dto.Post.UpdatePostRequestDto;
import com.godie.Blog.model.User;

import java.util.List;

public interface PostService {
    PostDto createPost(CreatePostRequestDto createPostRequestDto, User user);

    PostDto updatePost(UpdatePostRequestDto updatePostRequestDto, Long postId, User user);

    void deletePostById(Long id, User user);

    PostDto getPostById(Long id);

    List<PostWithoutStoryDto> getPostsWithoutStory();

    List<PostDto> getPostsByTagsId (Long id);

    Long calculateReadingTime(String text);
}

