package com.godie.Blog.service.impl;

import com.godie.Blog.dto.Post.PostDto;
import com.godie.Blog.dto.Tag.TagDto;
import com.godie.Blog.dto.Tag.TagsWithPostCountDto;
import com.godie.Blog.model.Tag;
import com.godie.Blog.model.User;
import com.godie.Blog.repository.TagRepository;
import com.godie.Blog.service.TagService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Tag> getTagsByIds(Set<Long> ids) {
        List<Tag> tags = tagRepository.findAllById(ids);
        if (tags.size() != ids.size()) {
            throw new EntityNotFoundException("Belirtilen etiketlerin tumu mevcut degil");
        }
        return tags;
    }

    @Override
    public Page<TagsWithPostCountDto> getTagsWithPostCount(Pageable pageable) {
        return tagRepository.findTagsWithPostCount(pageable);
    }

    @Override
    public Tag getTagById(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Etiket bulunamadi ID:" + id));
    }

    @Override
    public Page<TagDto> getTags(Pageable pageable) {
        return tagRepository.findAll(pageable)
                .map(tag -> modelMapper.map(tag, TagDto.class));
    }

    @Override
    public void deleteTagById(Long id, User user) {
        tagRepository.deleteById(id);
    }

    @Override
    public List<TagDto> createTags(Set<String> tagNames, User user) {
        Set<String> existingTagNames = tagRepository.findByNameIn(tagNames)
                .stream()
                .map(Tag::getName)
                .collect(Collectors.toSet());

        List<Tag> newTags = tagNames.stream()
                .filter(name -> !existingTagNames.contains(name))
                .map(name -> {
                    Tag tag = new Tag();
                    tag.setName(name);
                    return tag;
                })
                .collect(Collectors.toList());

        List<Tag> savedTags = tagRepository.saveAll(newTags);

        return savedTags.stream()
                .map(tag -> modelMapper.map(tag, TagDto.class))
                .collect(Collectors.toList());
    }

}