package com.vk.homework2.oktests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.vk.homework2.okpages.OkLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OkLoginTest {
    private OkLoginPage okLoginPage;

    @BeforeAll
    public static void setupClass(){
        Configuration.browser ="chrome";
        Configuration.baseUrl = "https://ok.ru/";
    }

    @BeforeEach
    public void setup(){
        okLoginPage = new OkLoginPage();
    }

    @AfterEach
    public void tearDown(){
        Selenide.closeWindow();
    }

    @Test
    public void testLoginSuccess(){
        //Enter username and password
        okLoginPage.login("user", "password");
    }
}
