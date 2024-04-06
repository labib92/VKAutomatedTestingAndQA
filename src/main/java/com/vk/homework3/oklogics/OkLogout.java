package com.vk.homework3.oklogics;

import com.vk.homework3.okpages.OkMainPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkLogout extends OkMainPage {

    private static final By logoutLink = By.xpath(".//a[@class='lp']");
    private static final By logoutDialogInput = By.xpath(".//input[@id='hook_FormButton_logoff.confirm_not_decorate']");
    private static final By submitButton = By.xpath(".//input[@class='button-pro __wide']");

    public OkLogout() {
        super();
        checkPage();
    }

    public void logoutSuccess() {
        $(profileSettingsButton).shouldBe(visible).click();
        $(logoutLink).shouldBe(visible).click();
        $(logoutDialogInput).shouldBe(visible).click();
    }

    public boolean logoutSuccessCheck() {
        return $(submitButton).shouldBe(visible).isDisplayed();
    }

}
