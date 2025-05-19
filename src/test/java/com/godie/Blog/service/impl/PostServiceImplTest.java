package com.godie.Blog.service.impl;

import com.godie.Blog.dto.Post.CreatePostRequestDto;
import com.godie.Blog.dto.Post.PostDto;
import com.godie.Blog.mapper.PostMapper;
import com.godie.Blog.model.Post;
import com.godie.Blog.model.User;
import com.godie.Blog.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private PostMapper postMapper;

    @InjectMocks
    private PostServiceImpl postService;

    @Test
    void createPost() {
        /*// Arrange
        User user = new User();
        user.setId(1L);
        user.setUsername("testuser");

        CreatePostRequestDto requestDto = new CreatePostRequestDto();
        requestDto.setTitle("Test Başlık");
        requestDto.setContent("Test içerik");

        Post post = new Post();
        post.setTitle("Test Başlık");
        post.setContent("Test içerik");

        Post savedPost = new Post();
        savedPost.setId(100L);
        savedPost.setTitle("Test Başlık");
        savedPost.setContent("Test içerik");
        savedPost.setCreatedBy(user);

        PostDto expectedDto = new PostDto();
        //expectedDto.setId(100L);
        expectedDto.setTitle("Test Başlık");
        expectedDto.setContent("Test içerik");

        // Mockito ayarları
        when(postMapper.toEntity(requestDto)).thenReturn(post);
        when(postRepository.save(post)).thenReturn(savedPost);
        when(postMapper.toDto(savedPost)).thenReturn(expectedDto);

        // Act
        PostDto result = postService.createPost(user, requestDto);

        // Assert
        assertEquals(expectedDto.getCreatedBy(), result.getCreatedBy());
        assertEquals(expectedDto.getTitle(), result.getTitle());
        assertEquals(expectedDto.getContent(), result.getContent());

        // Doğrulama
        verify(postMapper).toEntity(requestDto);
        verify(postRepository).save(post);
        verify(postMapper).toDto(savedPost);*/
    }
}