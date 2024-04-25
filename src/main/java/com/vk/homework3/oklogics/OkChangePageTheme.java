package com.vk.homework3.oklogics;

import com.codeborne.selenide.SelenideElement;
import com.vk.homework3.okpages.OkMainPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class OkChangePageTheme extends OkMainPage {
    private final static By SETTING_BUTTON = By.xpath(".//a[@class='u-menu_a ' and contains(@hrefattrs,'st.cmd=userConfig')]");
    private final static By DARK_THEME = By.xpath(".//li[@data-theme='dark']");
    private final static By LIGHT_THEME = By.xpath(".//li[@data-theme='light']");
    private final static By AUTO_THEME = By.xpath(".//li[@data-theme='auto']");
    private final static By SETTING_PHOTO_BUTTON = By.xpath(".//a[@data-l='t,userPhotos']");
    private final static By THEME_SWITCHER_CONTAINER = By.xpath(".//span[@class='user-settings_i_tx theme-switcher_container']");

    public OkChangePageTheme() {
        checkPage();
    }

    public void navigateToSettingsMenu() {
        $(NAVIGATOR_SIDE_USER_PAGE_HYPERLINK).shouldBe(visible).click();
        $(SETTING_BUTTON).shouldBe(visible.because("")).click();
    }

    public void changeToAutoTheme() {
        SelenideElement auto = $(AUTO_THEME).shouldBe(hidden);
        executeJavaScript("arguments[0].click();", auto);
    }

    public void changeToLightTheme() {
        SelenideElement light = $(LIGHT_THEME).shouldBe(hidden);
        executeJavaScript("arguments[0].click();", light);
    }

    public void changeToDarkTheme() {
        SelenideElement dark = $(DARK_THEME).shouldBe(hidden);
        executeJavaScript("arguments[0].click();", dark);
    }


    public String getThemeColorText(){
        return $(THEME_SWITCHER_CONTAINER).shouldBe(visible).getText();
    }

    public boolean checkSettingPhotoButton(){
        return $(SETTING_PHOTO_BUTTON).shouldBe(visible).isDisplayed();
    }
}
