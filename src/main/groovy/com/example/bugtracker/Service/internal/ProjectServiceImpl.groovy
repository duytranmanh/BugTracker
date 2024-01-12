package com.example.bugtracker.Service.internal

import com.example.bugtracker.Entities.Post
import com.example.bugtracker.Entities.Project
import com.example.bugtracker.Entities.User
import com.example.bugtracker.Entities.MemberStatus
import com.example.bugtracker.Service.ProjectService
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component(value = "baseProjectService")
@Order(999)
class ProjectServiceImpl implements ProjectService {
    @Override
    void changeStatus(Project project, User serviceUser, User statusChangedTarget, MemberStatus newStatus) {
            project.getDev().remove(statusChangedTarget)
            project.getUser().remove(statusChangedTarget)
            project.getAdmin().remove(statusChangedTarget)
            if (newStatus == MemberStatus.ADMIN) project.getAdmin().add(statusChangedTarget)
            if (newStatus == MemberStatus.DEVELOPER) project.getDev().add(statusChangedTarget)
            if (newStatus == MemberStatus.USER) project.getUser().add(statusChangedTarget)

    }

    @Override
    void addCollaborator (Project project, User serviceUser, User newCollaborator) {
            project.getUser().add(newCollaborator)
    }

    @Override
    void addPost(User serviceUser, Project project, Post post) {
        project.getPostCollection.add(post)
    }

    @Override
    void deletePost(User serviceUser, Project project, Post post) {
        project.getPostCollection.remove(post)
    }

    @Override
    void changeName(User serviceUser, Project project, String newName) {
        project.setName(newName)
    }

    @Override
    void changeDescription(User serviceUser, Project project, String newDescription) {
        project.setDescription(newDescription)
    }
}
