package com.vk.homework2.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.homework2.oklogics.OkCheckWeather;
import com.vk.homework2.okpages.OkLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.switchTo;

public class OkCheckWeatherTest extends BaseTest{

    private OkCheckWeather okCheckWeather;

    @BeforeEach
    public void setup(){
        OkLoginPage okLoginPage = new OkLoginPage();
        //Enter username and password
        okLoginPage.login("user", "password");
        okCheckWeather = new OkCheckWeather();
    }

    @AfterEach
    public void tearDown(){
        Selenide.closeWindow();
    }

    @Test
    public void testCheckWeather(){
        okCheckWeather.checkWeather();
        switchTo().window(1);
        Assertions.assertTrue(okCheckWeather.checkWeatherSuccess(),"check weather failed");
    }
}
