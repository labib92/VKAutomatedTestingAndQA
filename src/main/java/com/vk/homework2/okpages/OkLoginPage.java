package com.vk.homework2.okpages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OkLoginPage {

    private static final By usernameInput = By.xpath(".//input[@id='field_email']");
    private static final By passwordInput = By.xpath(".//input[@id='field_password']");
    private static final By submitButton = By.xpath(".//input[@class='button-pro __wide']");
    private static final By navigatorSideUserPageButton = By.xpath(".//a[contains(@class, 'nav-side_i  __with-ic __with-new-icons') and @data-l='t,userPage']");

    public OkLoginPage(){
        open("/");
        checkPage();
    }

    public void login(String username, String password){
        $(usernameInput).shouldBe(visible).sendKeys(username);
        $(passwordInput).shouldBe(visible).sendKeys(password);
        $(submitButton).shouldBe(visible).click();
    }

    public boolean successfulLogin(){
        return $(navigatorSideUserPageButton).shouldBe(visible).isDisplayed();
    }

    private void checkPage(){
        $(usernameInput).shouldBe(visible);
        $(passwordInput).shouldBe(visible);
        $(submitButton).shouldBe(visible);
    }
}
