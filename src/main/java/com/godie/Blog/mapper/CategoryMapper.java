package com.godie.Blog.mapper;

import com.godie.Blog.dto.Category.CategoryDto;
import com.godie.Blog.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto categoryDto);
    List<CategoryDto> toDto(List<Category> categoryList);
}
