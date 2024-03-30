package com.vk.homework2.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.homework2.oklogics.OkAddFriend;
import com.vk.homework2.okpages.OkLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OkAddFriendTest extends BaseTest{

    private OkAddFriend okAddFriendPage;

    @BeforeEach
    public void setup(){
        OkLoginPage okLoginPage = new OkLoginPage();
        //Enter username and password
        okLoginPage.login("user", "password");
        okAddFriendPage = new OkAddFriend();
    }

    @AfterEach
    public void tearDown() {
        okAddFriendPage.deleteFriend();
        Selenide.closeWindow();
    }

    @Test
    public void testAddFriend()  {
        okAddFriendPage.addFriend("labib saleh");
        Assertions.assertTrue(okAddFriendPage.checkAddFriend(), "friend request sent failed");
    }
}
