package com.godie.Blog.controller;

import com.godie.Blog.dto.request.AddPostRequest;
import com.godie.Blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/add")
    public void signin(@RequestBody AddPostRequest request) {
        postService.add(request);
        //return ResponseEntity.ok(postService.add(request));
    }
}
