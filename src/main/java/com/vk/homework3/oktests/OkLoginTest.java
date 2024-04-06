package com.vk.homework3.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.homework3.okpages.OkLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.TimeUnit;


@DisplayName("Ok.ru Login Test Class")
public class OkLoginTest extends BaseTest {
    private OkLoginPage okLoginPage;

    @BeforeEach
    public void setup() {
        log.info("Setup login test");
        okLoginPage = new OkLoginPage();
    }

    @AfterEach
    public void tearDown() {
        log.info("Closing the browser");
        Selenide.closeWindow();
    }

    @DisabledOnJre(JRE.JAVA_11)
    @ParameterizedTest
    @CsvSource({"user1, password1", "user2, password2"})
    @DisplayName("Test Login Success")
    @Tag("LoginSuccess")
    @Timeout(value = 10000, unit = TimeUnit.MILLISECONDS)
    public void testLoginSuccess(String username, String password) {
        log.info("Testing logging success");
        //Enter username and password
        okLoginPage.login(username, password);
        Assertions.assertAll("LoginSuccess",
                () -> Assertions.assertTrue(okLoginPage.successfulLogin1(), "Login failed: Incorrect username and/or password"),
                () -> Assertions.assertTrue(okLoginPage.successfulLogin2(), "Login failed: Incorrect username and/or password"));
    }
}
