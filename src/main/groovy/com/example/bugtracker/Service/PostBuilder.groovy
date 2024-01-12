package com.example.bugtracker.Service

import com.example.bugtracker.Entities.Post
import com.example.bugtracker.Entities.PostStatus
import com.example.bugtracker.Entities.User

interface PostBuilder {
    PostBuilder setTitle(String title)
    PostBuilder setDescription(String description)
    PostBuilder setCollaborator(Collection<User> collaborator)
    PostBuilder setStatus(PostStatus postStatus)
    Post build(User serviceUser)
}
