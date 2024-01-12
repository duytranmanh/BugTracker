package com.example.bugtracker

import com.example.bugtracker.Entities.MemberStatus
import com.example.bugtracker.Entities.Post
import com.example.bugtracker.Entities.Project
import com.example.bugtracker.Entities.User
import com.example.bugtracker.Service.internal.CommentConcreteBuilder
import com.example.bugtracker.Service.internal.PostConcreteBuilder
import com.example.bugtracker.Service.internal.ProjectConcreteBuilder
import com.example.bugtracker.Service.internal.ProjectServiceImpl
import com.example.bugtracker.Service.internal.UserConcreteBuilder
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest

import static org.junit.jupiter.api.Assertions.assertFalse
import static org.junit.jupiter.api.Assertions.assertFalse
import static org.junit.jupiter.api.Assertions.assertFalse
import static org.junit.jupiter.api.Assertions.assertTrue
import static org.junit.jupiter.api.Assertions.assertTrue
import static org.junit.jupiter.api.Assertions.assertTrue
import static org.junit.jupiter.api.Assertions.assertTrue

@SpringBootTest
class PostServiceImplTest {

    @Autowired
    private UserConcreteBuilder userConcreteBuilder

    @Autowired
    private PostConcreteBuilder postConcreteBuilder

    @Autowired
    @Qualifier("baseProjectService")
    private ProjectServiceImpl projectService
    
    @Test
    void testChangeStatus() {
        // Create a project for testing
        User admin = new User("ad", "1")
        User user = new User("user", "1");
        Project project = new Project(new ArrayList<>(Arrays.asList(admin)),
                new ArrayList<>(Arrays.asList(user)),
                new ArrayList<>());

        // Change the status of the user
        projectService.changeStatus(project, admin, user, MemberStatus.DEVELOPER);

        // Assert that the user's status has been changed
        assertTrue(project.getDev().contains(user));
        assertFalse(project.getAdmin().contains(user));
        assertFalse(project.getUser().contains(user));
        assertTrue(project.getDev().contains(user));
    }

    @Test
    void testAddCollaborator() {
        // Create a project for testing
        User admin = new User("ad", "1")
        User newCollaborator = new User("user", "1");
        Project project = new Project(new ArrayList<>(Arrays.asList(admin)),
                new ArrayList<>(),
                new ArrayList<>());
        // Add a collaborator to the project
        projectService.addCollaborator(project, admin, newCollaborator);

        // Assert that the collaborator has been added
        assertTrue(project.getUser().contains(newCollaborator));
    }

    @Test
    void testAddPost() {
        // Create a project for testing
        User test = userConcreteBuilder.build()
        Project project = new Project(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Post post = postConcreteBuilder.build(test)

        // Add a post to the project
        projectService.addPost(test, project, post);

        // Assert that the post has been added
        assertTrue(project.getPostCollection.contains(post));
    }

    @Test
    void testDeletePost() {
        // Create a project for testing
        User test = userConcreteBuilder.build()
        Post post = postConcreteBuilder.build(test)
        Project project = new Project(new ArrayList<>(),new ArrayList<>(), new ArrayList<>())
        project.getPostCollection.add(post)


        // Delete a post from the project
        projectService.deletePost(test, project, post);

        // Assert that the post has been removed
        assertFalse(project.getPostCollection.contains(post));
    }

}
