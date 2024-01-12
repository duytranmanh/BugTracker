package com.example.bugtracker.Service

import com.example.bugtracker.Entities.User

interface UserBuilder {
    UserBuilder setUsername(String username)
    UserBuilder setPassword(String password)
    User build()
}
