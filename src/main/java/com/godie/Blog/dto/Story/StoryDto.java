package com.godie.Blog.dto.Story;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoryDto {
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String content;
}
