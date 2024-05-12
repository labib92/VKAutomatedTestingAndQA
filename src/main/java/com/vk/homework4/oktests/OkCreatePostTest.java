package com.vk.homework4.oktests;

import com.vk.homework4.okpages.OkCreatePost;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

@DisplayName("Ok.ru Create Post Test Class")
public class OkCreatePostTest extends BaseTest {
    private OkCreatePost okCreatePost;
    private final String expectedPostText = "Hello, World";

    @AfterEach
    @Override
    public void tearDown() {
        log.info("Deleting the post and closing the browser");
        okCreatePost.deletePost();
        browserManager.closeBrowser();
    }

    @Test
    @DisplayName("Test Create Post")
    @Tag("CreatePost")
    @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
    public void testCreatePost() {
        log.info("Testing create post");
        okCreatePost = new OkCreatePost();
        okCreatePost.createPost(expectedPostText);
        Assertions.assertEquals(okCreatePost.successfulCreatePost().getText(), expectedPostText,
                "Post text should exist after creating a post");
    }
}
