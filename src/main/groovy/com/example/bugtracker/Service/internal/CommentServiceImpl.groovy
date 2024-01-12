package com.example.bugtracker.Service.internal

import com.example.bugtracker.Entities.Comment
import com.example.bugtracker.Entities.User
import com.example.bugtracker.Service.CommentService
import org.springframework.context.annotation.ComponentScan
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Component(value = "baseCommentService")
@Order(999)
class CommentServiceImpl implements CommentService {

    @Override
    void editComment(User serviceUser, Comment cmt, String content) {
        cmt.setContent(content);
    }
}
