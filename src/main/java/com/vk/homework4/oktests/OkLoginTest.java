package com.vk.homework4.oktests;

import com.vk.homework4.okpages.OkLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;


@DisplayName("Ok.ru Login Test Class")
public class OkLoginTest extends BaseTest {

    @BeforeEach
    @Override
    public void setup() {
        log.info("Setup Test");
        browserManager.openBrowser();
        okLoginPage = new OkLoginPage();
    }

    private static Stream<Arguments> loginUserData(){
        return Stream.of(Arguments.of("technopol71", "technopolisPassword"),
                Arguments.of("technopol71", "technopolisPassword"));
    }

    @DisabledOnJre(JRE.JAVA_8)
    @ParameterizedTest
    @MethodSource("loginUserData")
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
