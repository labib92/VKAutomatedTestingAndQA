package com.vk.homework4.patterns.decorator;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public interface OkCreateGroup {
    By CREATE_GROUP_BUTTON = By.xpath(".//input[@id='hook_FormButton_button_create']");
    By DELETE_PAGE_BUTTON = By.xpath(".//a[contains(text(),'Удалить')]");
    By CONFIRM_DELETE_BUTTON = By.xpath(".//input[@data-l='t,confirm']");

    void createGroup();

    void deleteGroup();

    SelenideElement getGroupNameHeader();
}
