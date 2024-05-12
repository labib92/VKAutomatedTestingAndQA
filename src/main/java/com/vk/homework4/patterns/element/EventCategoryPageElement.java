package com.vk.homework4.patterns.element;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class EventCategoryPageElement {
    private static final By LECTURE_CATEGORY = By.xpath(".//div[@data-id='24']");

    public void selectLectureCategory() {
        $(LECTURE_CATEGORY).shouldBe(visible
                .because("Lecture category should be visible before clicking it")).click();
    }
}
