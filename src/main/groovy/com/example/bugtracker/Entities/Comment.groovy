package com.example.bugtracker.Entities

import java.time.LocalDateTime;

/**
 * Comment class: contains information about comments a user made
 */
class Comment implements Serializable {
    //id
    private UUID id;
    private String content;
    private User author;
    private LocalDateTime createdDate
    private Post post

    Comment(String content, User author, Post post) {
        generateID();
        getCreatedDate()
        this.content = content;
        this.author = author;
        this.post = post
    }

    private LocalDateTime getCreatedDate() {
        createdDate = LocalDateTime.now()
        return createdDate
    }

    Post getPost() {
        return post
    }

    void setPost(Post post) {
        this.post = post
    }

    private void generateID() {
        id = UUID.randomUUID();
    }

    String getContent() {
        return content;
    }

    void setContent(String content) {
        this.content = content;
    }

    User getAuthor() {
        return author;
    }

    void setAuthor(User author) {
        this.author = author;
    }
}
