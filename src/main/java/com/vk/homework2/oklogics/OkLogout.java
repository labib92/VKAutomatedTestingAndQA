package com.vk.homework2.oklogics;

import com.vk.homework2.okpages.OkMainPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkLogout extends OkMainPage {
    private final By profileSettingsButton = By.xpath("//button[@class='ucard-mini toolbar_ucard js-toolbar-menu __a11y']");
    private final By logoutLink = By.xpath("//a[@class='lp']");
    private final By logoutDialogInput = By.xpath("//input[@id='hook_FormButton_logoff.confirm_not_decorate']");

    public OkLogout(){
        super();
    }

    public void logoutSuccess(){
        $(profileSettingsButton).shouldBe(visible).click();
        $(logoutLink).shouldBe(visible).click();
        $(logoutDialogInput).shouldBe(visible).click();
    }
}
