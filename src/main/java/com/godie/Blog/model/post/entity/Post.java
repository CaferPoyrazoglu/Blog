package com.godie.Blog.model.post.entity;

import com.godie.Blog.model.common.entity.BaseEntity;
import com.godie.Blog.model.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "POSTS")
public class Post extends BaseEntity {
    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATED_BY", nullable = true)
    private User createdBy;
}
