package com.example.bugtracker.Service.internal

import com.example.bugtracker.Entities.Project
import com.example.bugtracker.Entities.User
import com.example.bugtracker.Service.ProjectBuilder
import org.springframework.stereotype.Component

@Component
class ProjectConcreteBuilder implements ProjectBuilder {
    private Collection<User> admin
    private Collection<User> user
    private Collection<User> dev
    private String name
    private String description

    @Override
    ProjectBuilder setName(String name) {
        this.name = name
        return this
    }

    @Override
    ProjectBuilder setDescription(String description) {
        this.description = description
        return this
    }

    @Override
    ProjectBuilder setAdmin(Collection<User> adminCollection) {
        this.admin = adminCollection
        return this
    }

    @Override
    ProjectBuilder setUser(Collection<User> userCollection) {
        this.user = userCollection
        return this
    }

    @Override
    ProjectBuilder setDev(Collection<User> devCollection) {
        this.dev = devCollection
        return this
    }

    @Override
    Project build(User serviceUser) {
        return new Project(admin, user, dev)
    }
}
