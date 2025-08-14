package com.godie.Blog.service;

import com.godie.Blog.dto.Category.CreateCategoryRequestDto;
import com.godie.Blog.model.Category;

import java.util.List;


public interface CategoryService {
    Category createCategory(CreateCategoryRequestDto createCategoryRequestDto);

    void deleteCategory(Long id);

    Category getCategoryById(Long categoryId);

    List<Category> listCategories();
}
