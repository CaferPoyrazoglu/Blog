package com.godie.Blog.mapper;

import com.godie.Blog.dto.Category.CategoryDto;
import com.godie.Blog.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    @Mapping(target = "categoryName", source = "category.name")
    CategoryDto toDto(Category category);

    @Mapping(target = "name", source = "categoryName")
    Category toEntity(CategoryDto categoryDto);
}
