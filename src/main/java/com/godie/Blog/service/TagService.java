package com.godie.Blog.service;

import com.godie.Blog.dto.Tag.TagDto;
import com.godie.Blog.dto.Tag.TagsWithPostCountDto;
import com.godie.Blog.model.Tag;
import com.godie.Blog.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface TagService {
    void deleteTagById(Long id, User user);

    List<TagDto> createTags(Set<String> tagNames, User user);

    List<Tag> getTagsByIds(Set<Long> ids);

    Tag getTagById(Long id);

    Page<TagsWithPostCountDto> getTagsWithPostCount(Pageable pageable);

    Page<TagDto> getTags(Pageable pageable);
}
