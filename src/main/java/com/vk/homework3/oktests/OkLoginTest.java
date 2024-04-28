package com.vk.homework3.oktests;

import com.vk.homework3.okpages.OkLoginPage;
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

import static com.codeborne.selenide.Selenide.open;


@DisplayName("Ok.ru Login Test Class")
public class OkLoginTest extends BaseTest {

    @BeforeEach
    @Override
    public void setup() {
        log.info("Setup Test");
        open("/");
        okLoginPage = new OkLoginPage();
    }

    @DisabledOnJre(JRE.JAVA_11)
    @ParameterizedTest
    @CsvSource({"technopol71, technopolisPassword", "technopol71, technopolisPassword"})
    @DisplayName("Test Login Success")
    @Tag("LoginSuccess")
    @Timeout(value = 20000, unit = TimeUnit.MILLISECONDS)
    public void testLoginSuccess(String username, String password) {
        log.info("Testing logging success");
        okLoginPage.loginUsername(username);
        okLoginPage.loginPassword(password);
        okLoginPage.submit();
        Assertions.assertAll("Login Success",
                () -> Assertions.assertTrue(okLoginPage.getNavigatorSideUserPage().isDisplayed(),
                        "Navigator side user page button should be visible after login"),
                () -> Assertions.assertTrue(okLoginPage.getNavigatorSideGroupPage().isDisplayed(),
                        "Navigator side group page button should be visible after login"));
    }
}
