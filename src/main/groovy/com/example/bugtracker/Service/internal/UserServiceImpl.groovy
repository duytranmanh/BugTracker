package com.example.bugtracker.Service.internal

import com.example.bugtracker.Entities.User
import com.example.bugtracker.Entities.MemberStatus
import com.example.bugtracker.Service.UserService
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component(value = "baseUserService")
@Order(999)
class UserServiceImpl implements UserService{

    @Override
    void editUsername(User serviceUser, User impactedUser, String username) {
        serviceUser.setUsername(username)
    }

    @Override
    void editPassword(User serviceUser, User impactedUser, String newPassword, String oldPassword) {
        if (serviceUser.getPassword() == oldPassword)
            serviceUser.setPassword(newPassword)
    }
}
