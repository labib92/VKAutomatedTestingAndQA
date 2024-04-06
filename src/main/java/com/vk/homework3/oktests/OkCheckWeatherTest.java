package com.vk.homework3.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.homework3.oklogics.OkCheckWeather;
import com.vk.homework3.okpages.OkLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.switchTo;

@DisplayName("Ok.ru Check Weather Test Class")
public class OkCheckWeatherTest extends BaseTest {

    private OkCheckWeather okCheckWeather;

    @BeforeEach
    public void setup() {
        log.info("Setup check weather test");
        OkLoginPage okLoginPage = new OkLoginPage();
        //Enter username and password
        okLoginPage.login("user", "password");
        okCheckWeather = new OkCheckWeather();
    }

    @AfterEach
    public void tearDown() {
        log.info("Closing the browser");
        Selenide.closeWindow();
    }

    @Test
    @DisplayName("Test Check Weather Success")
    @Tag("CheckWeather")
    @Timeout(value = 10000, unit = TimeUnit.MILLISECONDS)
    public void testCheckWeather() {
        log.info("Testing check weather");
        okCheckWeather.checkWeather();
        switchTo().window(1);
        Assertions.assertTrue(okCheckWeather.checkWeatherSuccess(), "check weather failed");
    }
}
