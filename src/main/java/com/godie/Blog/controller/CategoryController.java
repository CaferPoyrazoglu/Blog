package com.godie.Blog.controller;

import com.godie.Blog.dto.Category.CategoryDto;
import com.godie.Blog.dto.Category.CreateCategoryRequestDto;
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

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories() {
        return ResponseEntity.ok(categoryService.listCategories());
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(
            @Valid @RequestBody CreateCategoryRequestDto createCategoryRequestDto) {
        CategoryDto categoryDto = categoryService.createCategory(createCategoryRequestDto);
        return new ResponseEntity<>(
                categoryDto,
                HttpStatus.CREATED
        );
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}