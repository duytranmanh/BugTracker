package com.example.bugtracker.Service

import com.example.bugtracker.Entities.Project
import com.example.bugtracker.Entities.User

interface ProjectBuilder {
    ProjectBuilder setName(String name)
    ProjectBuilder setDescription(String description)
    ProjectBuilder setAdmin(Collection<User> adminCollection)
    ProjectBuilder setUser(Collection<User> userCollection)
    ProjectBuilder setDev (Collection<User> devCollection)
    Project build(User serviceUser)

}
