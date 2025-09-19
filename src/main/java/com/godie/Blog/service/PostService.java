package com.godie.Blog.service;

import com.godie.Blog.dto.Post.CreatePostRequestDto;
import com.godie.Blog.dto.Post.PostDto;
import com.godie.Blog.dto.Post.PostWithoutStoryDto;
import com.godie.Blog.dto.Post.UpdatePostRequestDto;
import com.godie.Blog.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    PostDto createPost(CreatePostRequestDto createPostRequestDto, User user);

    PostDto updatePost(UpdatePostRequestDto updatePostRequestDto, Long postId, User user);

    void deletePostById(Long id, User user);

    PostDto getPostById(Long id);

    Page<PostWithoutStoryDto> getPostsWithoutStory(Pageable pageable);

    Page<PostDto> getPostsByTagsId(Long tagId, Pageable pageable);

    Long calculateReadingTime(String text);
}

