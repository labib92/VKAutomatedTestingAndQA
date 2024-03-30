package com.vk.homework2.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.homework2.okpages.OkLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OkLoginTest extends BaseTest{
    private OkLoginPage okLoginPage;

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
        Assertions.assertTrue(okLoginPage.successfulLogin(),"Login failed: Incorrect username and/or password");
    }
}
