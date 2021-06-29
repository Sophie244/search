package com.search.service;

import com.search.model.Post;
import java.util.List;

public interface PostService {
    List<Post> getAll();
    Post findOne(String id);
    Post create(Post post);
    Post update(Post post);
    List<Post> getPostByUsername(String username);
    List<Post> getContentContains(String searchString);

    void delete(String id);
}
