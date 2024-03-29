package com.search.dao;

import com.search.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, String> {
    List<User> findByUsername(String username);
}