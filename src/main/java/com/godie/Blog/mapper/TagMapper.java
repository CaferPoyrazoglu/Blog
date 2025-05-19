package com.godie.Blog.mapper;

import com.godie.Blog.dto.Tag.TagDto;
import com.godie.Blog.model.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TagMapper {
    @Mapping(target = "tag", source = "tag.name")
    TagDto toDto(Tag tag);

    @Mapping(target = "name", source = "tag")
    Tag toEntity(TagDto tagDto);

    List<TagDto> toTagListDto(List<Tag> tagList);

}
