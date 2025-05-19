package com.godie.Blog.service;

import com.godie.Blog.dto.Category.CategoryDto;
import com.godie.Blog.dto.Category.CreateCategoryRequestDto;
import com.godie.Blog.model.Category;


public interface CategoryService {
    CategoryDto createCategory(CreateCategoryRequestDto createCategoryRequestDto);
    Category getCategoryById(Long categoryId);
}
