package com.search.service;

import com.search.model.Comment;
import java.util.List;


public interface CommentService {

    List<Comment> getAll();
    Comment findOne(String id);
    Comment create(Comment greeting);
    Comment update(Comment greeting);
    List<Comment> getCommentByUsername(String username);
    void delete(String id);
//    void create(String id, Comment comment);
//    void delete(String id);
//
//    void deleteCommentsByPost(String id);
//
//
//    List<Comment> getUserComments(Long user);
//
//    Long countAllComments(Long user);
//
//    List<Comment> getCommentsByPost(String postId);
//
//    int countCommentsByUserAndMonth(Long id, short month);
}
