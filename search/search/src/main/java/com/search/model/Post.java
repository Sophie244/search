package com.search.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

import java.time.LocalDate;
import java.util.List;

@Document(indexName = "postadmin_posts")
public class Post implements Serializable{

    @Id
    private String id;
    @Field(type = FieldType.Text, name= "username")
    private String username;
    @Field(type = FieldType.Text, name= "content")
    private String content;
    @Field(type = FieldType.Text, name= "submitted")
    private String submitted;
    private List<Comment> commentList;

    public Post() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String text) {
        this.content = content;
    }

    public String getSubmitted() {
        return submitted;
    }

    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
