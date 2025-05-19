package com.godie.Blog.dto.Tag;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateTagRequestDto {

    @NotBlank(message = "Tag name is required")
    @Size(min = 2, max = 50, message = "Tag name must be between {min} and {max} characters")
    private String tag;
}
