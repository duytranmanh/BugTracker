package com.example.bugtracker.Service

import com.example.bugtracker.Entities.User

interface UserService {

    void editUsername(User serviceUser, User impactedUser, String username)

    void editPassword(User serviceUser, User impactedUser, String newPassword, String oldPassword)
}
