package com.vk.homework4.patterns.element;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class GroupAccessRadioButtonsPageElement {
    private static final By CLOSED_RADIO_CHECK_BUTTON = By.xpath(".//input[@id='field_visibility_BY_MEMBER_INVITATION_AND_REQUEST']");
    private static final By SECRET_RADIO_CHECK_BUTTON = By.xpath(".//input[@id='field_visibility_BY_MEMBER_INVITATION']");

    public void selectClosedAccessGroupRadioButton() {
        SelenideElement radioButton = $(CLOSED_RADIO_CHECK_BUTTON);
        radioButton.shouldNotBe(checked
                .because("Radio button should not be checked before clicking it"));
        executeJavaScript("arguments[0].checked = true;", radioButton);
        radioButton.should(checked
                .because("Radio button should be checked after clicking it"));
    }

    public void selectSecretAccessGroupRadioButton() {
        SelenideElement radioButton = $(SECRET_RADIO_CHECK_BUTTON);
        radioButton.shouldNotBe(checked
                .because("Radio button should not be checked before clicking it"));
        executeJavaScript("arguments[0].checked = true;", radioButton);
        radioButton.should(checked
                .because("Radio button should be checked after clicking it"));
    }
}
