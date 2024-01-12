package com.example.bugtracker.Service

import com.example.bugtracker.Entities.Comment
import com.example.bugtracker.Entities.User

import java.awt.Component

interface CommentService {
    void editComment(User userService, Comment comment, String content)
}
