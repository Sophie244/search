package com.search.dao;

import com.search.model.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import java.util.List;

public interface PostRepository extends ElasticsearchRepository<Post, String> {
    List<Post> findByUsername(String username);
    List<Post> findByContentContaining(String content);
}