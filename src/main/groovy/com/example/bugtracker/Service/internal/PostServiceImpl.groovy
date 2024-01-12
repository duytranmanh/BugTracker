package com.example.bugtracker.Service.internal

import com.example.bugtracker.Entities.Comment
import com.example.bugtracker.Entities.Post
import com.example.bugtracker.Entities.PostStatus
import com.example.bugtracker.Entities.User
import com.example.bugtracker.Service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

import javax.swing.text.html.ObjectView;

@Component(value = "basePostService")
@Order(999)
class PostServiceImpl implements PostService {

    @Override
    void changeStatus(User serviceUser, Post post, PostStatus status) {
        post.setStatus(status)
    }

    @Override
    void editTitle(User serviceUser, Post post, String title) {
        post.setTitle(title)
    }

    @Override
    void editDescription(User serviceUser, Post post, String description) {
        post.setDescription(description)
    }

    @Override
    void addCollaborator(User serviceUser, Post post, Collection<User> collaborator) {
        post.getCollaborators().addAll(collaborator)
    }

    @Override
    void removeCollaborator(User serviceUser, Post post, Collection<User> collaborator) {
        post.getCollaborators().removeAll(collaborator)
    }

    @Override
    void addComment(User serviceUser, Post post, Comment cmt) {
        post.getCommentsCollection().add(cmt)
    }

    @Override
    void deleteComment (User serviceUser, Post post, Comment cmt) {
        post.getCommentsCollection().remove(cmt)
    }
}
