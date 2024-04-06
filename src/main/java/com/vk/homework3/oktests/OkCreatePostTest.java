package com.vk.homework3.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.homework3.oklogics.OkCreatePost;
import com.vk.homework3.okpages.OkLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

@DisplayName("Ok.ru Create Post Test Class")
public class OkCreatePostTest extends BaseTest {
    private OkCreatePost okCreatePost;

    @BeforeEach
    public void setup() {
        log.info("Setup create post test");
        OkLoginPage okLoginPage = new OkLoginPage();
        //Enter username and password
        okLoginPage.login("user", "password");
        okCreatePost = new OkCreatePost();
    }

    @AfterEach
    public void tearDown() {
        log.info("Deleting the post and closing the browser");
        okCreatePost.deletePost();
        Selenide.closeWindow();
    }

    @Test
    @DisplayName("Test Create Post")
    @Tag("CreatePost")
    @Timeout(value = 10000, unit = TimeUnit.MILLISECONDS)
    public void testCreatePost() {
        log.info("Testing create post");
        okCreatePost.createPost("Hello, World!.");
        Assertions.assertTrue(okCreatePost.successfulCreatePost(), "Post is failed to create");
    }
}
