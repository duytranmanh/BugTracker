package com.example.bugtracker.Service

import com.example.bugtracker.Entities.Comment
import com.example.bugtracker.Entities.Post
import com.example.bugtracker.Entities.PostStatus
import com.example.bugtracker.Entities.User

interface PostService {

    void changeStatus(User serviceUser, Post post, PostStatus status)

    void editTitle(User serviceUser, Post post, String title)

    void editDescription(User serviceUser, Post post, String description)

    void addCollaborator(User serviceUser, Post post, Collection<User> collaborator)

    void removeCollaborator(User serviceUser, Post post, Collection<User> collaborator)

    void addComment(User serviceUser, Post post, Comment cmt)

    void deleteComment (User serviceUser, Post post, Comment cmt)
}
