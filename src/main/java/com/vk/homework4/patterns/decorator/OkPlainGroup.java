package com.vk.homework4.patterns.decorator;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class OkPlainGroup implements OkCreateGroup{

    @Override
    public void createGroup() {
        $(CREATE_GROUP_BUTTON).shouldBe(visible
                .because("Create button group should be visible before clicking it")).click();
    }

    @Override
    public void deleteGroup() {
        SelenideElement auto = $(DELETE_PAGE_BUTTON).shouldBe(hidden
                .because("Delete button should be hidden before clicking it"));
        executeJavaScript("arguments[0].click();", auto);
        $(CONFIRM_DELETE_BUTTON).shouldBe(visible
                .because("Confirm button should be visible before clicking it")).click();
    }

    @Override
    public SelenideElement getGroupNameHeader() {
        return null;
    }
}
