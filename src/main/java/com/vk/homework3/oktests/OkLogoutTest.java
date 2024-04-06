package com.vk.homework3.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.homework3.oklogics.OkLogout;
import com.vk.homework3.okpages.OkLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;


@DisplayName("Ok.ru Logout Test Class")
public class OkLogoutTest extends BaseTest {
    private OkLogout okLogout;

    @BeforeEach
    public void setup() {
        log.info("Setup logout test");
        OkLoginPage okLoginPage = new OkLoginPage();
        //Enter username and password
        okLoginPage.login("user", "password");
        okLogout = new OkLogout();
    }

    @AfterEach
    public void tearDown() {
        log.info("Closing the browser");
        Selenide.closeWindow();
    }

    @Test
    @DisplayName("Test Logout Success")
    @Tag("LogoutSuccess")
    @Timeout(value = 10000, unit = TimeUnit.MILLISECONDS)
    public void testLogout() {
        log.info("Testing logout");
        okLogout.logoutSuccess();
        Assertions.assertTrue(okLogout.logoutSuccessCheck(), "Logout failed");
    }
}
