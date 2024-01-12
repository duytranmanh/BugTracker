package com.example.bugtracker

import com.example.bugtracker.Entities.Comment
import com.example.bugtracker.Entities.Post
import com.example.bugtracker.Entities.PostStatus
import com.example.bugtracker.Entities.Project
import com.example.bugtracker.Entities.User
import com.example.bugtracker.Service.internal.CommentConcreteBuilder
import com.example.bugtracker.Service.internal.PostConcreteBuilder
import com.example.bugtracker.Service.internal.ProjectConcreteBuilder
import com.example.bugtracker.Service.internal.UserConcreteBuilder
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertNotNull

@SpringBootTest
class BuilderTest {

    @Autowired
    private UserConcreteBuilder userConcreteBuilder

    @Autowired
    private ProjectConcreteBuilder projectConcreteBuilder

    @Autowired
    private PostConcreteBuilder postConcreteBuilder

    @Autowired
    private CommentConcreteBuilder commentConcreteBuilder

    @Test
    void testBuildUser() {
        // Set the username and password using the UserBuilder methods
        User user = userConcreteBuilder.setUsername("john")
                .setPassword("password")
                .build()

        // Assert that the user object is not null
        assertNotNull(user)

        // Assert that the username and password are set correctly
        assertEquals("john", user.getUsername())
        assertEquals("password", user.getPassword())
    }

    @Test
    void testBuildProject() {
        Collection<User> adminCollection = Arrays.asList(new User("admin", "1"), new User("admin2", "1"));
        Collection<User> userCollection = Arrays.asList(new User("user1", "1"), new User("user2", "1"));
        Collection<User> devCollection = Arrays.asList(new User("dev1", "1"), new User("dev2", "1"));

        Project project = projectConcreteBuilder.setAdmin(adminCollection)
                .setUser(userCollection)
                .setDev(devCollection)
                .build();

        assertNotNull(project);
        assertEquals(adminCollection, project.getAdmin());
        assertEquals(userCollection, project.getUser());
        assertEquals(devCollection, project.getDev());
    }

    @Test
    void testBuildPost() {
        // Create necessary objects for testing
        Collection<User> collaboratorCollection = Arrays.asList(new User("collaborator1", "1"), new User("collaborator2", "1"));

        // Set the properties using the PostBuilder methods
        Post post = postConcreteBuilder.setTitle("Test Post")
                .setDescription("This is a test post")
                .setCollaborator(collaboratorCollection)
                .setStatus(PostStatus.IN_PROGRESS)
                .build();

        // Assert that the post object is not null
        assertNotNull(post);

        // Assert that the properties are set correctly
        assertEquals("Test Post", post.getTitle());
        assertEquals("This is a test post", post.getDescription());
        assertEquals(collaboratorCollection, post.getCollaborators());
        assertEquals(PostStatus.IN_PROGRESS, post.getStatus());
    }

    @Test
    void testBuildComment() {
        User test = userConcreteBuilder.build()
        String content = "Test comment";

        Comment comment = commentConcreteBuilder.setContent(content)
                .build(test);

        assertNotNull(comment);

        assertEquals(content, comment.getContent());
    }
}
