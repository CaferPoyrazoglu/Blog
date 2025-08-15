package com.godie.Blog.dto.Category;

import lombok.*;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String name;
}