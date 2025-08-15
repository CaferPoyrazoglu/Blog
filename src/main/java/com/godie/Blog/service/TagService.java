package com.godie.Blog.service;

import com.godie.Blog.model.Tag;
import com.godie.Blog.dto.Tag.TagWithPostCountDto;

import java.util.List;
import java.util.Set;

public interface TagService {
    List<Tag> getTags();

    List<TagWithPostCountDto> getTagsWithPostCount();

    void deleteTag(Long id);

    List<Tag> createTags(Set<String> tagNames);

    List<Tag> getTagsByIds(Set<Long> ids);

    Tag getTagById(Long id);
}
