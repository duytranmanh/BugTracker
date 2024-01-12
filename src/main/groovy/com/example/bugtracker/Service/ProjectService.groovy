package com.example.bugtracker.Service

import com.example.bugtracker.Entities.MemberStatus
import com.example.bugtracker.Entities.Post
import com.example.bugtracker.Entities.Project
import com.example.bugtracker.Entities.User

interface ProjectService {
    void changeStatus(Project project, User serviceUser, User statusChangeUser, MemberStatus newStatus)
    void addCollaborator(Project project, User serviceUser, User newCollaborator)
    void addPost(User serviceUser, Project project, Post post)
    void deletePost(User serviceUser, Project project, Post post)
    void changeName(User serviceUser, Project project, String newName)
    void changeDescription (User serviceUser, Project project, String newDescription)

}
