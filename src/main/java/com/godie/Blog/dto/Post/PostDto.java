package com.godie.Blog.dto.Post;

import com.godie.Blog.model.Category;
import com.godie.Blog.model.Tag;
import com.godie.Blog.model.User;
import lombok.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String title;
    private String content;
    private Category category;
    private Set<Tag> tags = new HashSet<>();
    private User createdBy;
}
