package com.godie.Blog.mapper;

import com.godie.Blog.dto.Post.CreatePostRequestDto;
import com.godie.Blog.dto.Post.PostDto;
import com.godie.Blog.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostMapper {
    PostDto toDto(Post post);
    Post toEntity(CreatePostRequestDto dto);

    List<PostDto> toPostListDto(List<Post> postList);
}
