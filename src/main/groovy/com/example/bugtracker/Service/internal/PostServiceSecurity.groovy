package com.example.bugtracker.Service.internal

import com.example.bugtracker.Entities.Comment
import com.example.bugtracker.Entities.Post
import com.example.bugtracker.Entities.PostStatus
import com.example.bugtracker.Entities.Project
import com.example.bugtracker.Entities.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpClientErrorException



@Component(value = "postServiceSecurity")
@Order(1)
class PostServiceSecurity extends PostServiceImpl{
    private static boolean isAuthor(Post post, User serviceUser) {
        return post.getAuthor() == serviceUser
    }

    private static boolean isMember(Post post, User serviceUser) {
        Project project = post.getProject()
        if (project.getUser().contains(serviceUser)) return true
        if (project.getDev().contains(serviceUser)) return true
        if (project.getAdmin().contains(serviceUser)) return true
    }

    private static boolean isCommentAuthor(User serviceUser, Comment comment) {
        return comment.getAuthor() == serviceUser
    }

    @Override
    void changeStatus(User serviceUser, Post post, PostStatus status) {
        if (!isAuthor(post, serviceUser)) throw new HttpClientErrorException.Unauthorized()
        super.changeStatus(serviceUser, post, status)
    }

    @Override
    void editTitle(User serviceUser, Post post, String title) {
        if (!isAuthor(post, serviceUser)) throw new HttpClientErrorException.Unauthorized()
        super.editTitle(serviceUser, post, title)
    }

    @Override
    void editDescription(User serviceUser, Post post, String description) {
        if (!isAuthor(post, serviceUser)) throw new HttpClientErrorException.Unauthorized()
        super.editDescription(serviceUser, post, description)
    }

    @Override
    void addCollaborator(User serviceUser, Post post, Collection<User> collaborator) {
        if (!isAuthor(post, serviceUser)) throw new HttpClientErrorException.Unauthorized()
        super.addCollaborator(serviceUser, post, collaborator)
    }

    @Override
    void removeCollaborator(User serviceUser, Post post, Collection<User> collaborator) {
        if (!isAuthor(post, serviceUser)) throw new HttpClientErrorException.Unauthorized()
        super.removeCollaborator(serviceUser, post, collaborator)
    }

    @Override
    void addComment(User serviceUser, Post post, Comment cmt) {
        if (!isMember()) throw new HttpClientErrorException.Unauthorized()
        post.getCommentsCollection().add(cmt)
    }

    @Override
    void deleteComment (User serviceUser, Post post, Comment cmt) {
        if (!isCommentAuthor(serviceUser, cmt) ) throw new HttpClientErrorException.Unauthorized()
        post.getCommentsCollection().remove(cmt)
    }
}
