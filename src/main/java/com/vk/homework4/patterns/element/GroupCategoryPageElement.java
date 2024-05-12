package com.vk.homework4.patterns.element;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GroupCategoryPageElement {
    private static final By CAR_CATEGORY = By.xpath(".//div[@data-id='Category_CARS_MACHINERY']");
    private static final By FOOD_CATEGORY = By.xpath(".//div[@data-id='Category_CAFE_RESTAURANT']");

    public void selectCarCategory() {
        $(CAR_CATEGORY).shouldBe(visible
                .because("Car category should be visible before clicking it")).click();
    }

    public void selectFoodCategory() {
        $(FOOD_CATEGORY).shouldBe(visible
                .because("Food category should be visible before clicking it")).click();
    }
}
