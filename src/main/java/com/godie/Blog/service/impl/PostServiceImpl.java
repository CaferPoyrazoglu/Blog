package com.godie.Blog.service.impl;

import com.godie.Blog.dto.Post.CreatePostRequestDto;
import com.godie.Blog.dto.Post.PostDto;
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
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    @Override
    public PostDto createPost(CreatePostRequestDto createPostRequestDto, User user) {
        Post newPost = new Post();
        newPost.setTitle(createPostRequestDto.getTitle());
        newPost.setContent(createPostRequestDto.getContent());
        newPost.setDescription(createPostRequestDto.getDescription());
        newPost.setReadingTime(calculateReadingTime(createPostRequestDto.getContent()));
        newPost.setCreatedBy(user);

        Category category = categoryService.getCategoryById(createPostRequestDto.getCategoryId());
        newPost.setCategory(category);

        Set<Long> tagIds = createPostRequestDto.getTagIds();
        List<Tag> tags = tagService.getTagsByIds(tagIds);
        newPost.setTags(new HashSet<>(tags));

        Post savedPost = postRepository.save(newPost);

        return modelMapper.map(savedPost, PostDto.class);
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
    public List<PostDto> getPosts() {
        return postRepository.findAllWithCategoryAndTags().stream()
                .map(post -> modelMapper.map(post, PostDto.class)) // ModelMapper ile dönüşüm
                .toList();
    }

}
