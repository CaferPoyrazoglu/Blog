package com.godie.Blog.repository;

import com.godie.Blog.model.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, String> {
}
