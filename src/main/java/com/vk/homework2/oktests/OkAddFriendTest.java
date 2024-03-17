package com.vk.homework2.oktests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.vk.homework2.oklogics.OkAddFriend;
import com.vk.homework2.okpages.OkLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OkAddFriendTest {

    private OkAddFriend okAddFriendPage;

    @BeforeAll
    public static void setupClass(){
        Configuration.browser ="chrome";
        Configuration.baseUrl = "https://ok.ru/";
    }

    @BeforeEach
    public void setup(){
        OkLoginPage okLoginPage = new OkLoginPage();
        okAddFriendPage = new OkAddFriend();
        //Enter username and password
        okLoginPage.login("user", "password");
    }

    @AfterEach
    public void tearDown(){
        Selenide.closeWindow();
    }

    @Test
    public void testAddFriend()  {
        okAddFriendPage.addFriend("labib saleh");
    }
}
