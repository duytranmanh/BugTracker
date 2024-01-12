package com.example.bugtracker.Service.internal

import com.example.bugtracker.Entities.User
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpClientErrorException

@Component(value = "userServiceSecurity")
@Order(1)
class UserServiceSecurity extends UserServiceImpl{
    private static boolean isAuthorized(User serviceUser, User impactedUser) {
        return serviceUser == impactedUser
    }
    @Override
    void editUsername(User serviceUser, User impactedUser, String username) {
        if (!isAuthorized(serviceUser, impactedUser)) throw new HttpClientErrorException.Unauthorized()
        super.editUsername(serviceUser, impactedUser, username)
    }

    @Override
    void editPassword(User serviceUser, User impactedUser, String newPassword, String oldPassword) {
        if (!isAuthorized(serviceUser, impactedUser)) throw new HttpClientErrorException.Unauthorized()
        super.editPassword(serviceUser, impactedUser, newPassword, oldPassword)
    }
}
