package com.search.controller;

import com.search.model.Comment;
import com.search.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> getAll() {
        return new ResponseEntity<List<Comment>>(commentService.getAll(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public ResponseEntity<Comment> insertComment(@RequestBody Comment comment) {
        return new ResponseEntity<Comment>(commentService.create(comment), HttpStatus.CREATED);
    }

    @ResponseBody
    @RequestMapping(value = "/comments", method = RequestMethod.PUT)
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
        return new ResponseEntity<Comment>(commentService.update(comment), HttpStatus.MOVED_PERMANENTLY);
    }

    @ResponseBody
    @RequestMapping(value = "/comments/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Comment> deleteComment(@PathVariable("id") String idd) {
        commentService.delete(idd);
        return new ResponseEntity<Comment>(HttpStatus.NO_CONTENT);
    }

    @ResponseBody
    @RequestMapping(value = "/comments{id}", method = RequestMethod.POST)
    public ResponseEntity<Comment> getOne(@PathVariable("id") String idd) {
        return new ResponseEntity<Comment>(commentService.findOne(idd), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/comments/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> getByUserName(@PathVariable("name") String name) {
        return new ResponseEntity<List<Comment>>(commentService.getCommentByUsername(name), HttpStatus.OK);
    }


}