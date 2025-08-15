package com.godie.Blog.dto.Tag;

import lombok.*;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagDto {
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String name;
}
