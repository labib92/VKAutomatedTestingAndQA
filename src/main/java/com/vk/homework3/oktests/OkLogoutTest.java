package com.vk.homework3.oktests;

import com.vk.homework3.oklogics.OkLogout;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;


@DisplayName("Ok.ru Logout Test Class")
public class OkLogoutTest extends BaseTest {

    @Test
    @DisplayName("Test Logout Success")
    @Tag("LogoutSuccess")
    @Timeout(value = 10000, unit = TimeUnit.MILLISECONDS)
    public void testLogout() {
        log.info("Testing logout");
        OkLogout okLogout = new OkLogout();
        okLogout.logoutSuccess();
        Assertions.assertAll("Logout Success",
                () -> Assertions.assertTrue(okLogout.getUsernameField().isDisplayed(),
                        "Username field should be visible after logout"),
                () -> Assertions.assertTrue(okLogout.getPasswordField().isDisplayed(),
                        "Password field should be visible after logout"),
                () -> Assertions.assertTrue(okLogout.getSubmitButton().isDisplayed(),
                        "Submit button should be visible after logout"));
    }
}
