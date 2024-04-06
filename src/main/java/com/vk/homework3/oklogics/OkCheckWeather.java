package com.vk.homework3.oklogics;

import com.vk.homework3.okpages.OkMainPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkCheckWeather extends OkMainPage {
    private static final By weatherLinkButton = By.xpath(".//a[contains(@class, 'vk-ecosystem-link') and @data-l='t,weather']");
    private static final By mailLogoLink = By.xpath(".//img[@class='pm-logo__link__pic']");

    public OkCheckWeather() {
        super();
        checkPage();
    }

    public void checkWeather() {
        $(toolbarButton).shouldBe(visible).click();
        $(weatherLinkButton).shouldBe(visible).click();
    }

    public boolean checkWeatherSuccess() {
        return $(mailLogoLink).shouldBe(visible).isDisplayed();
    }

}
