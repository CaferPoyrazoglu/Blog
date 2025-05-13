package com.godie.Blog.service;

import com.godie.Blog.dto.request.AddNoteRequest;
import com.godie.Blog.dto.request.DeleteNoteRequest;
import com.godie.Blog.dto.request.EditPostRequest;
import com.godie.Blog.model.post.entity.Post;
import com.godie.Blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post add(AddNoteRequest request) {
        Post post = Post.builder().title(request.getTitle()).content(request.getContent()).build();
        return postRepository.save(post);
    }

    public Boolean delete(DeleteNoteRequest request) {
        Post post = postRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException("Not found!"));
        postRepository.delete(post);
        return true;
    }

    public Post edit(EditPostRequest request) {
        Post post = postRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException("Not found!"));

        post.setTitle(request.getTitle());
        post.setContent(request.getContent());

        return postRepository.save(post);
    }

    public Post getPostById(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Not found!"));

        return post;
    }

    public Page<Post> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }
}
