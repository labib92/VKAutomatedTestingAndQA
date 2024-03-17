package com.vk.homework2.oktests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.vk.homework2.oklogics.OkCreatePost;
import com.vk.homework2.okpages.OkLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OkCreatePostTest {
    private OkCreatePost okCreatePost;

    @BeforeAll
    public static void setupClass(){
        Configuration.browser ="chrome";
        Configuration.baseUrl = "https://ok.ru/";
    }

    @BeforeEach
    public void setup(){
        OkLoginPage okLoginPage = new OkLoginPage();
        okCreatePost = new OkCreatePost();
        //Enter username and password
        okLoginPage.login("user", "password");
    }

    @AfterEach
    public void tearDown(){
        Selenide.closeWindow();
    }

    @Test
    public void testCreatePost()  {
        okCreatePost.createPost("Hello, World!.");
    }
}
