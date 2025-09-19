package com.godie.Blog.service.impl;

import com.godie.Blog.model.Story;
import com.godie.Blog.repository.StoryRepository;
import com.godie.Blog.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoryServiceImpl implements StoryService {
    private final StoryRepository storyRepository;

    @Override
    public Story createStory(Story story) {
        return storyRepository.save(story);
    }

    @Override
    public Story updateStory(Story story) {
        Story existingStory = storyRepository.findById(story.getId())
                .orElseThrow(() -> new IllegalArgumentException("Story bulunamadı: " + story.getId()));
        existingStory.setContent(story.getContent());
        return storyRepository.save(existingStory);
    }
}
