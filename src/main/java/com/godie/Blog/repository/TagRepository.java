package com.godie.Blog.repository;

import com.godie.Blog.dto.Tag.TagsWithPostCountDto;
import com.godie.Blog.model.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByNameIn(Set<String> names);

    Page<Tag> findAll(Pageable pageable);

    @Query(value = """
            SELECT
                t.id AS id,
                t.name AS name,
                t.created_at AS createdAt,
                t.updated_at AS updatedAt,
                COUNT(pt.post_id) AS postCount
            FROM tags t
            LEFT JOIN post_tags pt ON t.id = pt.tag_id
            GROUP BY t.id, t.name
            """, nativeQuery = true)
    Page<TagsWithPostCountDto> findTagsWithPostCount(Pageable pageable);
}
