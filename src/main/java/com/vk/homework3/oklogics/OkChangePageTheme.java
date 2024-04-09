package com.vk.homework3.oklogics;

import com.codeborne.selenide.SelenideElement;
import com.vk.homework3.okpages.OkMainPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class OkChangePageTheme extends OkMainPage {
    private final static By settingButton = By.xpath(".//a[@class='u-menu_a ' and contains(@hrefattrs,'st.cmd=userConfig')]");
    private final static By darkTheme = By.xpath(".//li[@class='u-menu_li theme-switcher_item' and contains(@data-theme,'dark')]");
    private final static By lightTheme = By.xpath(".//li[@class='u-menu_li theme-switcher_item' and contains(@data-theme,'light')]");
    private final static By autoTheme = By.xpath(".//li[@class='u-menu_li theme-switcher_item' and contains(@data-theme,'auto')]");
    private final static By settingFriendButton = By.xpath(".//a[@class='mctc_navMenuSec ellip-menu-item ' and contains(@data-l,'t,userFriend')]");
    private final static By settingPhotoButton = By.xpath(".//a[@class='mctc_navMenuSec ellip-menu-item ' and contains(@data-l,'t,userPhotos')]");

    public OkChangePageTheme() {
        super();
        checkPage();
    }

    public void navigateToSettingsMenu() {
        $(navigatorSideUserPageButton).shouldBe(visible).click();
        $(settingButton).shouldBe(visible).click();
    }

    public void changeToAutoTheme() {
        SelenideElement auto = $(autoTheme);
        auto.shouldBe(hidden);
        executeJavaScript("arguments[0].click();", auto);
    }

    public void changeToLightTheme() {
        SelenideElement light = $(lightTheme);
        light.shouldBe(hidden);
        executeJavaScript("arguments[0].click();", light);
    }

    public void changeToDarkTheme() {
        SelenideElement dark = $(darkTheme);
        dark.shouldBe(hidden);
        executeJavaScript("arguments[0].click();", dark);
    }

    public boolean checkSettingFriendButton(){
        return $(settingFriendButton).shouldBe(visible).isDisplayed();
    }

    public boolean checkSettingPhotoButton(){
        return $(settingPhotoButton).shouldBe(visible).isDisplayed();
    }
}
