package com.example.bugtracker.Service.internal

import com.example.bugtracker.Entities.Post
import com.example.bugtracker.Entities.PostStatus
import com.example.bugtracker.Entities.Project
import com.example.bugtracker.Entities.User
import com.example.bugtracker.Service.PostBuilder
import org.springframework.stereotype.Component

/**
 * this class create a new instance of post
 * @author duy
 */
@Component
class PostConcreteBuilder implements PostBuilder{
    private String title
    private String description
    private Collection<User> collaborator
    private PostStatus postStatus
    private User author
    private Project project

    @Override
    PostBuilder setTitle(String title) {
        this.title = title
        return this
    }

    @Override
    PostBuilder setDescription(String description) {
        this.description = description
        return this
    }

    @Override
    PostBuilder setCollaborator(Collection<User> collaborator) {
        this.collaborator = collaborator
        return this
    }

    @Override
    PostBuilder setStatus(PostStatus postStatus) {
        this.postStatus = postStatus
        return this
    }

    @Override
    Post build(User serviceUser) {
        return new Post(postStatus, title, description, author, collaborator, project)
    }
}
