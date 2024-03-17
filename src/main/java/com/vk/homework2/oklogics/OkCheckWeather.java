package com.vk.homework2.oklogics;

import com.vk.homework2.okpages.OkMainPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkCheckWeather extends OkMainPage {
    private final By toolbarButton = By.xpath("//button[@class='toolbar_nav_a toolbar_nav_a__vk_ecosystem __a11y']");
    private final By weatherLinkButton = By.xpath("//a[contains(@class, 'vk-ecosystem-link') and @data-l='t,weather']");

    public OkCheckWeather(){
        super();
    }

    public void checkWeather(){
        $(toolbarButton).shouldBe(visible).click();
        $(weatherLinkButton).shouldBe(visible).click();
    }
}
