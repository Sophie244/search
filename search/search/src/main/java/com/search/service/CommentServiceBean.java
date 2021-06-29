package com.search.service;

import com.google.common.collect.Lists;
import com.search.dao.CommentRepository;
import com.search.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceBean implements CommentService {

    @Autowired
    private CommentRepository repository;

    @Override
    public List<Comment> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public Comment findOne(String id) {
        return repository.findById(id).orElseGet(null);
    }

    @Override
    public Comment create(Comment comment) {
        return repository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
        Comment persitedGreeting = repository.findById(comment.getId()).orElseGet(null);
        if(persitedGreeting == null) {
            return null;
        }
        return repository.save(comment);
    }

    @Override
    public List<Comment> getCommentByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

//public class CommentServiceBean {
//
//    private CommentRepository commentRepository;
//    private CommentService commentService;
//
//
//    private CommentService CommentService;

//    public void create(Comment comment) {
//        comment.setSubmitted(LocalDate.now());
//        commentRepository.save(comment);
//    }
//
//    public void create(String id, Comment comment) {
//        Comment comment = commentService.getCommentById(id);
//        if (comment == null) {
//            return;
//        }
//        comment.setCommentId(comment.getId());
//        comment.setSubmitted(LocalDate.now());
//        commentRepository.save(comment);
//    }
//
//    public List<Comment> getUserComments(Long user) {
//        return mapToComment(commentRepository.findByUser(user));
//    }
//
//    public List<Comment> getCommentsByPost(String postId) {
//        return mapToComment(commentRepository.findAllByPostId(postId));
//    }
//
//    private List<Comment> mapToCommentModel(List<Comment> comments) {
//        List<Comment> commentModels = new ArrayList<>();
//        for (Comment c : comments) {
//            commentModels.add(modelMapper.map(c, CommentModel.class));
//        }
//
//
//
//    public void delete(String id) {
//        commentRepository.deleteById(id);
//    }
//
//    public void deleteCommentsByPost(String id) { commentRepository.deleteAllByPostId(id); }
//
//

}
