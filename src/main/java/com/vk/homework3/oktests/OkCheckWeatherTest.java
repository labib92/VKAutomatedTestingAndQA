package com.vk.homework3.oktests;

import com.vk.homework3.okpages.OkCheckWeather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.switchTo;

@DisplayName("Ok.ru Check Weather Test Class")
public class OkCheckWeatherTest extends BaseTest {

    @Test
    @DisplayName("Test Check Weather Success")
    @Tag("CheckWeather")
    @Timeout(value = 10000, unit = TimeUnit.MILLISECONDS)
    public void testCheckWeather() {
        log.info("Testing check weather");
        OkCheckWeather okCheckWeather = new OkCheckWeather();
        okCheckWeather.checkWeather();
        switchTo().window(1);
        Assertions.assertTrue(okCheckWeather.getMailWeatherLogo().isDisplayed(),
                "Mail weather logo should be visible after entering the weather page");
    }
}
