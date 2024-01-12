package com.example.bugtracker

import com.example.bugtracker.Entities.Comment
import com.example.bugtracker.Entities.MemberStatus
import com.example.bugtracker.Entities.Post
import com.example.bugtracker.Entities.PostStatus
import com.example.bugtracker.Entities.Project
import com.example.bugtracker.Entities.User
import com.example.bugtracker.Service.UserBuilder
import com.example.bugtracker.Service.internal.CommentConcreteBuilder
import com.example.bugtracker.Service.internal.PostConcreteBuilder
import com.example.bugtracker.Service.internal.ProjectConcreteBuilder
import com.example.bugtracker.Service.internal.ProjectServiceImpl
import com.example.bugtracker.Service.internal.UserConcreteBuilder
import com.example.bugtracker.Service.internal.UserServiceImpl
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class BugTrackerApplicationTests {


}


