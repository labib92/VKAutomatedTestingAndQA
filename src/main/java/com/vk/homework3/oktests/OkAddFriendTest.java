package com.vk.homework3.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.homework3.oklogics.OkAddFriend;
import com.vk.homework3.okpages.OkLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;


@DisplayName("Ok.ru Add Friend Test Class")
public class OkAddFriendTest extends BaseTest {

    private OkAddFriend okAddFriendPage;

    @BeforeEach
    public void setup() {
        log.info("Setup add friend test");
        OkLoginPage okLoginPage = new OkLoginPage();
        //Enter username and password
        okLoginPage.login("user", "password");
        okAddFriendPage = new OkAddFriend();
    }

    @AfterEach
    public void tearDown() {
        log.info("Deleting friend request and closing the browser");
        okAddFriendPage.deleteFriend();
        Selenide.closeWindow();
    }

    @Test
    @DisplayName("Test Add Friend Success")
    @Tag("AddFriend")
    @Timeout(value = 10000, unit = TimeUnit.MILLISECONDS)
    public void testAddFriend() {
        log.info("Testing add friend");
        okAddFriendPage.addFriend("labib saleh");
        Assertions.assertTrue(okAddFriendPage.checkAddFriend(), "friend request sent failed");
    }
}
