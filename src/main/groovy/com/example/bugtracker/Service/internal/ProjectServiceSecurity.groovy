package com.example.bugtracker.Service.internal

import com.example.bugtracker.Entities.MemberStatus
import com.example.bugtracker.Entities.Post
import com.example.bugtracker.Entities.Project
import com.example.bugtracker.Entities.User
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpClientErrorException

/**
 * this class is responsible for authorizing service
 *
 * @author duy
 */
@Component(value = "projectServiceSecurity")
@Order(1)
class ProjectServiceSecurity extends ProjectServiceImpl{
    @Override
    void changeStatus(Project project, User serviceUser, User impactedUser, MemberStatus newStatus) {
        if (!project.getAdmin().contains(serviceUser)) throw new HttpClientErrorException.Unauthorized()

        super.changeStatus(project,serviceUser,impactedUser,newStatus)
    }

    @Override
    void addCollaborator (Project project, User serviceUser, User newCollaborator) {
        if (!project.getAdmin().contains(serviceUser)) throw new HttpClientErrorException.Unauthorized()

        super.addCollaborator(project, serviceUser, newCollaborator)
    }

    @Override
    void addPost(User serviceUser, Project project, Post post) {
        if (!project.getAdmin().contains(serviceUser) ||
            !project.getUser().contains(serviceUser)) throw new HttpClientErrorException.Unauthorized()

        super.addPost(serviceUser, project, post)
    }

    @Override
    void deletePost(User serviceUser, Project project, Post post) {
        if (post.getAuthor() != serviceUser) throw new HttpClientErrorException.Unauthorized()

        super.deletePost(serviceUser, project, post)
    }

    @Override
    void changeName(User serviceUser, Project project, String newName) {
        if (!project.getAdmin().contains(serviceUser)) throw new HttpClientErrorException.Unauthorized()

        super.changeName(serviceUser, project, newName)
    }

    @Override
    void changeDescription(User serviceUser, Project project, String newDescription) {
        if (!project.getAdmin().contains(serviceUser)) throw new HttpClientErrorException.Unauthorized()

        super.changeDescription(serviceUser, project, newDescription)
    }
}
