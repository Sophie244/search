package com.search.controller;

import com.search.model.User;
import com.search.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<List<User>>(userService.getAll(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> insertUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.create(user), HttpStatus.CREATED);
    }

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.update(user), HttpStatus.MOVED_PERMANENTLY);
    }

    @ResponseBody
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") String idd) {
        userService.delete(idd);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    @ResponseBody
    @RequestMapping(value = "/users{id}", method = RequestMethod.POST)
    public ResponseEntity<User> getOne(@PathVariable("id") String idd) {
        return new ResponseEntity<User>(userService.findOne(idd), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/users/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getByUserName(@PathVariable("name") String name) {
        return new ResponseEntity<List<User>>(userService.getUserByUsername(name), HttpStatus.OK);
    }
}