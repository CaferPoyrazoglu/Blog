package com.godie.Blog.repository;

import com.godie.Blog.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByNameIn(Set<String> names);
}
