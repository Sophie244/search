package com.search.service;

import com.google.common.collect.Lists;
import com.search.dao.PostRepository;
import com.search.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceBean implements PostService {

    @Autowired
    private PostRepository repository;

    @Override
    public List<Post> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public Post findOne(String id) {
        return repository.findById(id).orElseGet(null);
    }

    @Override
    public Post create(Post post) {
        return repository.save(post);
    }

    @Override
    public Post update(Post post) {
        Post persitedPost = repository.findById(post.getId()).orElseGet(null);
        if(persitedPost == null) {
            return null;
        }
        return repository.save(post);
    }

    @Override
    public List<Post> getPostByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public List<Post> getContentContains(String content) {
        return repository.findByContentContaining(content);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
