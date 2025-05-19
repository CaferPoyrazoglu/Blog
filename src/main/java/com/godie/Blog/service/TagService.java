package com.godie.Blog.service;

import com.godie.Blog.model.Tag;

import java.util.List;
import java.util.Set;

public interface TagService {
    List<Tag> getTags();

    void deleteTag(Long id);

    Tag getTagById(Long id);

    List<Tag> getTagByIds(Set<Long> ids);
}
