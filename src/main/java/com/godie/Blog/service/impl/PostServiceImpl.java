package com.godie.Blog.service.impl;

import com.godie.Blog.dto.Post.CreatePostRequestDto;
import com.godie.Blog.dto.Post.PostDto;
import com.godie.Blog.dto.Post.PostWithoutStoryDto;
import com.godie.Blog.dto.Post.UpdatePostRequestDto;
import com.godie.Blog.model.*;
import com.godie.Blog.repository.PostRepository;
import com.godie.Blog.service.CategoryService;
import com.godie.Blog.service.PostService;
import com.godie.Blog.service.StoryService;
import com.godie.Blog.service.TagService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CategoryService categoryService;
    private final StoryService storyService;
    private final TagService tagService;
    private final ModelMapper modelMapper;

    @Override
    public PostDto createPost(CreatePostRequestDto dto, User user) {
        Story story = buildAndSaveStory(dto);
        Post post = buildPost(dto, user, story);

        Post savedPost = postRepository.save(post);
        return modelMapper.map(savedPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(UpdatePostRequestDto updatePostRequestDto, Long postId, User user) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("Post bulunamadı ID:" + postId));


        post.setTitle(updatePostRequestDto.getTitle());
        post.setDescription(updatePostRequestDto.getDescription());

        if (updatePostRequestDto.getContent() != null) {
            post.getStory().setContent(updatePostRequestDto.getContent());
            post.setReadingTime(calculateReadingTime(updatePostRequestDto.getContent()));
            storyService.updateStory(post.getStory());
        }

        if (updatePostRequestDto.getCategoryId() != null) {
            post.setCategory(fetchCategory(updatePostRequestDto.getCategoryId()));
        }

        if (updatePostRequestDto.getTagIds() != null) {
            post.setTags(fetchTags(updatePostRequestDto.getTagIds()));
        }

        Post updatedPost = postRepository.save(post);
        return modelMapper.map(updatedPost, PostDto.class);
    }

    @Override
    public Long calculateReadingTime(String content) {
        if (content == null || content.trim().isEmpty()) {
            return 0L;
        } else {
            int wordCount = content.trim().split("\\s+").length;
            int averageReadingSpeed = 200;

            return (long) Math.ceil((double) wordCount / averageReadingSpeed);
        }
    }

    @Override
    public void deletePostById(Long id, User user) {
        postRepository.deleteById(id);
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post bulunamadi ID:" + id));

        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public Page<PostDto> getPostsByTagsId(Long tagId, Pageable pageable) {
        return postRepository.findByTagsId(tagId, pageable)
                .map(post -> modelMapper.map(post, PostDto.class));
    }

    @Override
    public Page<PostWithoutStoryDto> getPostsWithoutStory(Pageable pageable) {
        return postRepository.findAll(pageable)
                .map(post -> modelMapper.map(post, PostWithoutStoryDto.class));
    }

    private Story buildAndSaveStory(CreatePostRequestDto dto) {
        Story story = new Story();
        story.setContent(dto.getContent());
        return storyService.createStory(story);
    }

    private Post buildPost(CreatePostRequestDto dto, User user, Story story) {
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setDescription(dto.getDescription());
        post.setReadingTime(calculateReadingTime(dto.getContent()));
        post.setCreatedBy(user);
        post.setStory(story);

        post.setCategory(fetchCategory(dto.getCategoryId()));
        post.setTags(fetchTags(dto.getTagIds()));

        return post;
    }

    private Category fetchCategory(Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        if (category == null) {
            throw new IllegalArgumentException("Kategori bulunamadı: " + categoryId);
        }
        return category;
    }

    private Set<Tag> fetchTags(Set<Long> tagIds) {
        if (tagIds == null || tagIds.isEmpty()) {
            return Collections.emptySet();
        }
        return new HashSet<>(tagService.getTagsByIds(tagIds));
    }

}
