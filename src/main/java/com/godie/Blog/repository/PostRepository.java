package com.godie.Blog.repository;

import com.godie.Blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p JOIN FETCH p.category LEFT JOIN FETCH p.tags")
    List<Post> findAllWithCategoryAndTags();
}
