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
    public List<TagsWithPostCountDto> getTagsWithPostCount() {
        return tagRepository.findTagsWithPostCount();
    }

    @Override
    public Tag getTagById(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Etiket bulunamadi ID:" + id));
    }

    @Override
    public List<TagDto> getTags() {
        return tagRepository.findAll().stream()
                .map(tag -> modelMapper.map(tag, TagDto.class))
                .toList();
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