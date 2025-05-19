package com.godie.Blog.service;

import com.godie.Blog.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();

    Category createCategory(Category category);

    void deleteCategory(Long id);

    Category getCategoryById(Long id);
}
