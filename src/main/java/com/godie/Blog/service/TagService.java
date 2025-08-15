package com.godie.Blog.service;

import com.godie.Blog.dto.Tag.TagDto;
import com.godie.Blog.dto.Tag.TagsWithPostCountDto;
import com.godie.Blog.model.Tag;

import java.util.List;
import java.util.Set;

public interface TagService {
    List<Tag> getTags();

    List<TagsWithPostCountDto> getTagsWithPostCount();

    void deleteTag(Long id);

    List<TagDto> createTags(Set<String> tagNames);

    List<Tag> getTagsByIds(Set<Long> ids);

    Tag getTagById(Long id);
}
