package com.godie.Blog.controller;

import com.godie.Blog.dto.Tag.CreateTagRequestDto;
import com.godie.Blog.dto.Tag.TagDto;
import com.godie.Blog.dto.Tag.TagsWithPostCountDto;
import com.godie.Blog.service.AuthenticationService;
import com.godie.Blog.service.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;
    private final AuthenticationService authenticationService;


    @GetMapping
    public ResponseEntity<List<TagsWithPostCountDto>> getTagsWithPostCount() {
        return ResponseEntity.ok(tagService.getTagsWithPostCount());
    }

    @PostMapping
    public ResponseEntity<List<TagDto>> createTags(@Valid @RequestBody CreateTagRequestDto createTagsRequestDto) {
        List<TagDto> savedTags = tagService.createTags(createTagsRequestDto.getNames(), authenticationService.getAuthenticatedUser());
        return new ResponseEntity<>(
                savedTags,
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTagById(@PathVariable Long id) {
        tagService.deleteTagById(id, authenticationService.getAuthenticatedUser());
        return ResponseEntity.noContent().build();
    }

}
