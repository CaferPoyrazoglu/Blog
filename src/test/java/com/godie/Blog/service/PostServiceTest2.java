package com.godie.Blog.service;

import com.godie.Blog.dto.request.AddPostRequest;
import com.godie.Blog.model.post.entity.Post;
import com.godie.Blog.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest2 {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @Test
    void add() {
        Post post = Post.builder().title("postTitle").content("postContent").build();
        AddPostRequest addPostRequest = AddPostRequest.builder().title("postTitle").content("postContent").build();
        when(postRepository.save(Mockito.any(Post.class))).thenReturn(post);
        Post savedPost = postService.add(addPostRequest);
        assertNotNull(savedPost);
    }
}