package com.godie.Blog.service;

import com.godie.Blog.dto.request.AddPostRequest;
import com.godie.Blog.model.post.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    void add() {
        Post post = Post.builder().title("title").content("content").build();
        Post savedPost = postService.add(AddPostRequest.builder().title("title").content("content").build());
        assertNotNull(savedPost);
    }

}