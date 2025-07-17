package com.godie.Blog.controller;

import com.godie.Blog.dto.Tag.CreateTagRequestDto;
import com.godie.Blog.model.Tag;
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

    @GetMapping
    public ResponseEntity<List<Tag>> getAllTags() {
        return ResponseEntity.ok(tagService.getTags());
    }

    @PostMapping
    public ResponseEntity<List<Tag>> createTags(@Valid @RequestBody CreateTagRequestDto createTagsRequestDto) {
        List<Tag> savedTags = tagService.createTags(createTagsRequestDto.getNames());
        return new ResponseEntity<>(
                savedTags,
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }

}
