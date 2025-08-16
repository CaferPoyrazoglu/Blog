package com.godie.Blog.service;

import com.godie.Blog.dto.Category.CategoryDto;
import com.godie.Blog.dto.Category.CreateCategoryRequestDto;
import com.godie.Blog.model.Category;
import com.godie.Blog.model.User;

import java.util.List;


public interface CategoryService {
    CategoryDto createCategory(CreateCategoryRequestDto createCategoryRequestDto, User user);

    void deleteCategoryById(Long id, User user);

    Category getCategoryById(Long categoryId);

    List<CategoryDto> getCategories();
}
