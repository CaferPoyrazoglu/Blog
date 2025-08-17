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
}
