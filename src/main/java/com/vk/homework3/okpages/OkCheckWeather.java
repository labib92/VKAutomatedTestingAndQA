package com.vk.homework3.okpages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkCheckWeather extends OkBasePage {
    private static final By WEATHER_LINK_BUTTON = By.xpath(".//a[@data-l='t,weather']");
    private static final By MAIL_LOGO_LINK = By.xpath(".//img[@class='pm-logo__link__pic']");

    public OkCheckWeather() {
        super();
    }

    public void checkWeather() {
        $(TOOLBAR_BUTTON).shouldBe(visible
                .because("Toolbar should be visible before we click it")).click();
        $(WEATHER_LINK_BUTTON).shouldBe(visible
                .because("Weather link button should be visible before we click it")).click();
    }

    public SelenideElement getMailWeatherLogo() {
        return $(MAIL_LOGO_LINK).shouldBe(visible
                .because("The mail logo should be visible after entering the weather page"));
    }
}
