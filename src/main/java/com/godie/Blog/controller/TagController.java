package com.godie.Blog.controller;

import com.godie.Blog.dto.Tag.CreateTagRequestDto;
import com.godie.Blog.dto.Tag.TagDto;
import com.godie.Blog.dto.Tag.TagsWithPostCountDto;
import com.godie.Blog.service.AuthenticationService;
import com.godie.Blog.service.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity<Page<TagDto>> getTags(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "createdAt"));
        return ResponseEntity.ok(tagService.getTags(pageable));
    }

    @GetMapping("/with-post-count")
    public ResponseEntity<Page<TagsWithPostCountDto>> getTagsWithPostCount(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "createdAt"));
        return ResponseEntity.ok(tagService.getTagsWithPostCount(pageable));
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
