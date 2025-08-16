package com.godie.Blog.controller;

import com.godie.Blog.dto.Category.CategoryDto;
import com.godie.Blog.dto.Category.CreateCategoryRequestDto;
import com.godie.Blog.service.AuthenticationService;
import com.godie.Blog.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final AuthenticationService authenticationService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(
            @Valid @RequestBody CreateCategoryRequestDto createCategoryRequestDto) {
        CategoryDto createdCategory = categoryService.createCategory(createCategoryRequestDto, authenticationService.getAuthenticatedUser());
        return new ResponseEntity<>(
                createdCategory,
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteCategoryById(id, authenticationService.getAuthenticatedUser());
        return ResponseEntity.noContent().build();
    }
}