package com.search.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Document(indexName = "postadmin_posts")
public class Comment implements Serializable{

    @Id
    private String id;
    private String postId;
    private String username;
    private LocalDate submitted;
    private String content;

    public Comment() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
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

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getSubmitted() {
        return submitted;
    }

    public void setSubmitted(LocalDate submitted) {
        this.submitted = submitted;
    }
}
