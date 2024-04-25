package com.vk.homework3.oklogics;

import com.codeborne.selenide.SelenideElement;
import com.vk.homework3.okpages.OkMainPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkLogout extends OkMainPage {

    private static final By LOGOUT_LINK = By.xpath(".//a[@class='lp']");
    private static final By LOGOUT_DIALOG_INPUT = By.xpath(".//input[@id='hook_FormButton_logoff.confirm_not_decorate']");
    private static final By SUBMIT_BUTTON = By.xpath(".//input[@class='button-pro __wide']");
    private static final By USERNAME_INPUT = By.xpath(".//input[@id='field_email']");
    private static final By PASSWORD_INPUT = By.xpath(".//input[@id='field_password']");

    public OkLogout() {
        super();
    }

    public void logoutSuccess() {
        $(PROFILE_SETTINGS_BUTTON).shouldBe(visible
                .because("Profile setting hyperlink button should be visible before we can click it")).click();
        $(LOGOUT_LINK).shouldBe(visible
                .because("Logout hyperlink button should be visible before we can click it")).click();
        $(LOGOUT_DIALOG_INPUT).shouldBe(visible
                .because("Logout dialog input should be visible before we can click it")).click();
    }

    public SelenideElement getSubmitButton() {
        return $(SUBMIT_BUTTON).shouldBe(visible);
    }

    public SelenideElement getUsernameField(){
        return $(USERNAME_INPUT).shouldBe(visible);
    }

    public SelenideElement getPasswordField(){
        return $(PASSWORD_INPUT).shouldBe(visible);
    }

}
