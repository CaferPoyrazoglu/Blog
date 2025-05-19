package com.godie.Blog.service.impl;

import com.godie.Blog.dto.Post.CreatePostRequestDto;
import com.godie.Blog.dto.Post.PostDto;
import com.godie.Blog.dto.Post.UpdatePostRequestDto;
import com.godie.Blog.mapper.PostMapper;
import com.godie.Blog.model.Category;
import com.godie.Blog.model.Post;
import com.godie.Blog.model.Tag;
import com.godie.Blog.model.User;
import com.godie.Blog.repository.PostRepository;
import com.godie.Blog.service.CategoryService;
import com.godie.Blog.service.PostService;
import com.godie.Blog.service.TagService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CategoryService categoryService;
    private final TagService tagService;
    private final PostMapper postMapper;

    @Override
    public Post getPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post does not exist with ID " + id));
    }

    @Override
    public List<Post> getAllPosts(Long categoryId, Long tagId) {
        return postRepository.findAll();
    }

    @Override
    public PostDto createPost(User authenticatedUser, CreatePostRequestDto createPostRequestDto) {
        Post post = postMapper.toEntity(createPostRequestDto);
        post.setCreatedBy(authenticatedUser);
        Post savedPost = postRepository.save(post);
        return postMapper.toDto(savedPost);
    }

    @Override
    public PostDto updatePost(User authenticatedUser, UpdatePostRequestDto updatePostRequestDto) {
        Post existingPost = postRepository.findById(updatePostRequestDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Post does not exist"));

        existingPost.setTitle(updatePostRequestDto.getTitle());
        existingPost.setContent(updatePostRequestDto.getContent());

        existingPost.setCreatedBy(authenticatedUser);

        Category category = categoryService.getCategoryById(updatePostRequestDto.getCategoryId());
        existingPost.setCategory(category);

        Set<Long> updatePostRequestTagIds = updatePostRequestDto.getTagIds();
        List<Tag> newTags = tagService.getTagByIds(updatePostRequestTagIds);
        existingPost.setTags(new HashSet<>(newTags));

        Post updatedPost = postRepository.save(existingPost);

        return postMapper.toDto(updatedPost);
    }

    @Override
    public void deletePost(Long id) {
        Post post = getPost(id);
        postRepository.delete(post);
    }
}
