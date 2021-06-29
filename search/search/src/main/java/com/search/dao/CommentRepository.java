package com.search.dao;

import com.search.model.Comment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CommentRepository extends ElasticsearchRepository<Comment, String> {
    List<Comment> findByUsername(String username);
}