package com.godie.Blog.repository;


import com.godie.Blog.model.Category;
import com.godie.Blog.model.Post;
import com.godie.Blog.model.Tag;
import com.godie.Blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByCategoryAndTagsContaining(Category category, Tag tag);
    List<Post> findAllByCategory(Category category);
    List<Post> findAllByTagsContaining(Tag tag);

    // 1. JOIN FETCH ile
    @Query("SELECT p FROM Post p JOIN FETCH p.category LEFT JOIN FETCH p.tags")
    List<Post> findAllWithCategoryAndTags();
}
