package com.godie.Blog.service.impl;

import com.godie.Blog.dto.Post.CreatePostRequestDto;
import com.godie.Blog.dto.Post.PostDto;
import com.godie.Blog.mapper.PostMapper;
import com.godie.Blog.model.Category;
import com.godie.Blog.model.Post;
import com.godie.Blog.model.Tag;
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
    public PostDto createPost(CreatePostRequestDto createPostRequestDto) {
        Post newPost = new Post();
        newPost.setTitle(createPostRequestDto.getTitle());
        newPost.setContent(createPostRequestDto.getContent());
        newPost.setCreatedBy(null);

        Category category = categoryService.getCategoryById(createPostRequestDto.getCategoryId());
        newPost.setCategory(category);

        Set<Long> tagIds = createPostRequestDto.getTagIds();
        List<Tag> tags = tagService.getTagByIds(tagIds);
        newPost.setTags(new HashSet<>(tags));

        Post savedPost = postRepository.save(newPost);
        return postMapper.toDto(savedPost);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public PostDto getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with id" + id));
        return postMapper.toDto(post);
    }

    @Override
    public List<PostDto> getAllPosts() {
        return postMapper.toPostListDto(postRepository.findAll());
    }

}
