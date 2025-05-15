package com.godie.Blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TAGS")
public class Tag extends BaseEntity {
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;
}

