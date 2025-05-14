package com.godie.Blog.service;

import com.godie.Blog.dto.request.AddPostRequest;
import com.godie.Blog.model.post.entity.Post;
import com.godie.Blog.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Gerçek DB kullanmak istersen
class PostServiceTest3 {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Test
    void add() {
        AddPostRequest request = AddPostRequest.builder()
                .title("My Title")
                .content("My Content")
                .build();

        Post savedPost = postService.add(request);

        assertNotNull(savedPost.getId()); // veritabanı tarafından atanmalı
        assertEquals("My Title", savedPost.getTitle());

        // Opsiyonel: Veritabanından tekrar kontrol et
        Post fromDb = postRepository.findById(savedPost.getId()).orElseThrow();
        assertEquals("My Content", fromDb.getContent());
    }
}