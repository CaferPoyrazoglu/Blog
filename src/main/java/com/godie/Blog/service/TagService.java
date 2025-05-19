package com.godie.Blog.service;

import com.godie.Blog.dto.Tag.TagDto;
import com.godie.Blog.model.Tag;

import java.util.List;
import java.util.Set;

public interface TagService {
    List<TagDto> getTags();

    Tag getTagById(Long id);

    void deleteTag(Long id);

    List<TagDto> createTags(Set<String> tagNames);

    List<Tag> getTagByIds(Set<Long> ids);
}
