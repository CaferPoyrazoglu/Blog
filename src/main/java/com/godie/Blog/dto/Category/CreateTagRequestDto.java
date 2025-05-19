package com.godie.Blog.dto.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateTagRequestDto {
    @NotBlank(message = "Category name is required")
    @Size(min = 2, max = 20, message = "Category name must be between {min} and {max} characters")
    private String categoryName;
}
