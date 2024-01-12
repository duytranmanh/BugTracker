package com.example.bugtracker.Service.internal

import com.example.bugtracker.Entities.Comment
import com.example.bugtracker.Entities.Post
import com.example.bugtracker.Entities.User
import com.example.bugtracker.Service.CommentBuilder
import org.springframework.stereotype.Component

/**
 * this class create a new instance of comment
 * @author duy
 */
@Component
class CommentConcreteBuilder implements CommentBuilder{
    private String content
    private User author
    private Post post

    @Override
    CommentBuilder setContent(String content) {
        this.content = content
        return this
    }

    @Override
    Comment build(User serviceUser) {
        return new Comment(content, author, post)
    }
}
