package com.godie.Blog.dto.Tag;

import java.sql.Timestamp;

public interface TagsWithPostCountDto {
    Long getId();

    String getName();

    Long getPostCount();

    Timestamp getCreatedAt();

    Timestamp getUpdatedAt();
}
