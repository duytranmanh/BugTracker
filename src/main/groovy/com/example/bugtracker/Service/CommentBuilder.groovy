package com.example.bugtracker.Service

import com.example.bugtracker.Entities.Comment
import com.example.bugtracker.Entities.User
import org.springframework.stereotype.Component

interface CommentBuilder {
    CommentBuilder setContent(String content)
    Comment build(User serviceUser)
}
