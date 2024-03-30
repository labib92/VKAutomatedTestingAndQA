package com.vk.homework2.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.homework2.oklogics.OkCreatePost;
import com.vk.homework2.okpages.OkLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OkCreatePostTest extends BaseTest{
    private OkCreatePost okCreatePost;

    @BeforeEach
    public void setup(){
        OkLoginPage okLoginPage = new OkLoginPage();
        //Enter username and password
        okLoginPage.login("user", "password");
        okCreatePost = new OkCreatePost();
    }

    @AfterEach
    public void tearDown(){
        okCreatePost.deletePost();
        Selenide.closeWindow();
    }

    @Test
    public void testCreatePost()  {
        okCreatePost.createPost("Hello, World!.");
        Assertions.assertTrue(okCreatePost.successfulCreatePost(), "Post is failed to create");
    }
}
