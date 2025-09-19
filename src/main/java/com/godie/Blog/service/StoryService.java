package com.godie.Blog.service;

import com.godie.Blog.model.Story;

public interface StoryService {
    Story createStory(Story story);

    Story updateStory(Story story);
}
