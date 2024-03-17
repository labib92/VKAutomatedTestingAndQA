package com.vk.homework2.okpages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OkLoginPage {

    private final By usernameInput = By.xpath("//input[@id='field_email']");
    private final By passwordInput = By.xpath("//input[@id='field_password']");
    private final By submitButton = By.xpath("//input[@class='button-pro __wide']");
    private final By messageToolbarButton = By.xpath("//button[@id='msg_toolbar_button']");

    public OkLoginPage(){
        open("/");
    }

    public void login(String username, String password){
        $(usernameInput).shouldBe(visible).sendKeys(username);
        $(passwordInput).shouldBe(visible).sendKeys(password);
        $(submitButton).shouldBe(visible).click();
        $(messageToolbarButton).shouldBe(visible).doubleClick();
    }
}
