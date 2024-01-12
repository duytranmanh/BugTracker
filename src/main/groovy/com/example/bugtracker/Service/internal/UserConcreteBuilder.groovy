package com.example.bugtracker.Service.internal

import com.example.bugtracker.Entities.User
import com.example.bugtracker.Service.UserBuilder
import org.springframework.stereotype.Component

/**
 * this class create a new instance of user
 * @author duy
 */
@Component
class UserConcreteBuilder implements UserBuilder{
    private String username
    private String password

    @Override
    UserBuilder setUsername(String username) {
        this.username = username
        return this
    }

    @Override
    UserBuilder setPassword(String password) {
        this.password = password
        return this
    }

    @Override
    User build() {
        return new User(username, password)
    }
}
