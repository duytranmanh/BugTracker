package com.example.bugtracker.Entities

import java.time.LocalDateTime

/**
 * A post contains the issues/tasks created by a user
 * @author duy
 */
class Post implements Serializable {

    private UUID id;
    private PostStatus status;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private User author;
    private Collection<User> collaborators;
    private Collection<Comment> commentsCollection;
    private Project project

    Post(PostStatus status, String title, String description, User author,
         Collection<User> collaborators, Project project) {
        generateID();
        getStartDate()
        this.status = status;
        this.title = title;
        this.description = description;
        this.author = author;
        this.collaborators = collaborators;
    }

    private LocalDateTime getStartDate() {
        startDate = LocalDateTime.now()
        return startDate
    }

    private void generateID() {
        id = UUID.randomUUID();
    }

    Project getProject() {
        return project
    }

    void setProject(Project project) {
        this.project = project
    }

    public UUID getId() {
        return id;
    }

    public Collection<Comment> getCommentsCollection() {
        return commentsCollection;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Collection<User> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(Collection<User> collaborators) {
        this.collaborators = collaborators;
    }
}


