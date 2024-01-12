package com.example.bugtracker.Service.internal

import com.example.bugtracker.Entities.Comment
import com.example.bugtracker.Entities.User
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpClientErrorException

@Component(value = "commentServiceSecurity")
@Order(1)
class CommentServiceSecurity extends CommentServiceImpl{

    @Override
    void editComment(User serviceUser, Comment cmt, String content) {
        if (cmt.getAuthor() != serviceUser) throw new HttpClientErrorException.Unauthorized()
        super.editComment(serviceUser, cmt, content)
    }
}
