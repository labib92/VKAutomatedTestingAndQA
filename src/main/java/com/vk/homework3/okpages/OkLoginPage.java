package com.vk.homework3.okpages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkLoginPage {

    private static final By USERNAME_INPUT = By.xpath(".//input[@id='field_email']");
    private static final By PASSWORD_INPUT = By.xpath(".//input[@id='field_password']");
    private static final By SUBMIT_BUTTON = By.xpath(".//input[@class='button-pro __wide']");

    public OkLoginPage() {
        checkPage();
    }

    public void loginUsername(String username) {
        $(USERNAME_INPUT).shouldBe(visible
                .because("We need to input the username")).sendKeys(username);
    }

    public void loginPassword(String password){
        $(PASSWORD_INPUT).shouldBe(visible
                .because("We need to input the password")).sendKeys(password);
    }

    public void submit(){
        $(SUBMIT_BUTTON).shouldBe(visible
                .because("We need to click the submit button")).click();
    }

    public SelenideElement getNavigatorSideGroupPage() {
        return $(OkMainPage.NAVIGATOR_SIDE_GROUP_PAGE_HYPERLINK).shouldBe(visible);
    }

    public SelenideElement getNavigatorSideUserPage(){
        return $(OkMainPage.NAVIGATOR_SIDE_USER_PAGE_HYPERLINK).shouldBe(visible);
    }

    private void checkPage() {
        $(USERNAME_INPUT).shouldBe(visible);
        $(PASSWORD_INPUT).shouldBe(visible);
        $(SUBMIT_BUTTON).shouldBe(visible);
    }
}
