package com.godie.Blog.dto.Post;

import com.godie.Blog.dto.Category.CategoryDto;
import com.godie.Blog.model.Category;
import com.godie.Blog.model.Tag;
import com.godie.Blog.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    private String title;
    private String content;
    private CategoryDto category;
    private Set<Tag> tags = new HashSet<>();
    private User createdBy;
}
