package com.search.controller;

import com.search.model.Post;
import com.search.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @ResponseBody
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> getAll() {
        return new ResponseEntity<List<Post>>(postService.getAll(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public ResponseEntity<Post> insertPost(@RequestBody Post post) {
        System.out.println(post.getContent());
        return new ResponseEntity<Post>(postService.create(post), HttpStatus.CREATED);
    }

    @ResponseBody
    @RequestMapping(value = "/posts", method = RequestMethod.PUT)
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        return new ResponseEntity<Post>(postService.update(post), HttpStatus.MOVED_PERMANENTLY);
    }

    @ResponseBody
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Post> deletePost(@PathVariable("id") String idd) {
        postService.delete(idd);
        return new ResponseEntity<Post>(HttpStatus.NO_CONTENT);
    }

    @ResponseBody
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.POST)
    public ResponseEntity<Post> getOne(@PathVariable("id") String idd) {
        return new ResponseEntity<Post>(postService.findOne(idd), HttpStatus.OK);
    }
//
//    @ResponseBody
//    @RequestMapping(value = "/posts/{name}", method = RequestMethod.GET)
//    public ResponseEntity<List<Post>> getByUserName(@PathVariable("name") String name) {
//        return new ResponseEntity<List<Post>>(postService.getPostByUsername(name), HttpStatus.OK);
//    }

    @ResponseBody
    @RequestMapping(value = "/posts/{searchterm}", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> getContentContains(@PathVariable("searchterm") String searchterm) {
        System.out.println(searchterm);
        return new ResponseEntity<List<Post>>(postService.getContentContains(searchterm), HttpStatus.OK);
    }
}