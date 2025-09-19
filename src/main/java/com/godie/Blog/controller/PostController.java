package com.godie.Blog.controller;

import com.godie.Blog.dto.Post.CreatePostRequestDto;
import com.godie.Blog.dto.Post.PostDto;
import com.godie.Blog.dto.Post.PostWithoutStoryDto;
import com.godie.Blog.dto.Post.UpdatePostRequestDto;
import com.godie.Blog.service.AuthenticationService;
import com.godie.Blog.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final AuthenticationService authenticationService;


    @GetMapping
    public ResponseEntity<List<PostWithoutStoryDto>> getPostsWithoutStory() {
        return ResponseEntity.ok(postService.getPostsWithoutStory());
    }

    @GetMapping(path = "/tag/{tagId}")
    public ResponseEntity<List<PostDto>> getPostsByTagId(@PathVariable Long tagId) {
        return ResponseEntity.ok(postService.getPostsByTagsId(tagId));
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(
            @Valid @RequestBody CreatePostRequestDto createPostRequestDto) {
        PostDto createdPost = postService.createPost(createPostRequestDto, authenticationService.getAuthenticatedUser());
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long id) {
        postService.deletePostById(id, authenticationService.getAuthenticatedUser());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostDto> updatePost(
            @PathVariable Long postId,
            @Valid @RequestBody UpdatePostRequestDto updatePostRequestDto) {
        PostDto updatedPost = postService.updatePost(updatePostRequestDto, postId, authenticationService.getAuthenticatedUser());
        return ResponseEntity.ok(updatedPost);
    }
}
