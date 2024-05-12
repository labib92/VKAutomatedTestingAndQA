package com.vk.homework4.patterns.element;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CityCategoryPageElement {
    private static final By SAINT_PETERSBURG = By.xpath(".//div[@data-value='Санкт-Петербург']");

    public void selectSaintPetersburgCity() {
        $(SAINT_PETERSBURG).shouldBe(visible
                .because("Saint Petersburg city field should be visible before clicking it")).click();
    }
}
