package com.godie.Blog.repository;

import com.godie.Blog.model.Tag;
import com.godie.Blog.model.TagWithPostCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByNameIn(Set<String> names);

    @Query(value = """
        SELECT
            t.name AS name,
            COUNT(pt.post_id) AS postCount
        FROM tags t
        LEFT JOIN post_tags pt ON t.id = pt.tag_id
        GROUP BY t.id, t.name
        ORDER BY postCount DESC
        """, nativeQuery = true)
    List<TagWithPostCount> findTagsWithPostCount();
}
