package com.vk.homework4.okpages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;

public class OkChangePageTheme extends OkBasePage {
    private final static By SETTING_BUTTON = By.xpath(".//a[@class='u-menu_a ' and contains(@hrefattrs,'st.cmd=userConfig')]");
    private final static By DARK_THEME = By.xpath(".//li[@data-theme='dark']");
    private final static By LIGHT_THEME = By.xpath(".//li[@data-theme='light']");
    private final static By AUTO_THEME = By.xpath(".//li[@data-theme='auto']");
    private final static By THEME_SWITCHER_CONTAINER = By.xpath(".//span[@class='user-settings_i_tx theme-switcher_container']");
    private final static By TOOLBAR_LOGO_HYPERlINK = By.xpath(".//a[@id='toolbar_logo_id']");

    public OkChangePageTheme() {
        super();
    }

    public OkChangePageTheme navigateToSettingsMenu() {
        $(NAVIGATOR_SIDE_USER_PAGE_HYPERLINK).shouldBe(visible
                        .because("Navigator side user page should be visible before clicking it"),
                Duration.ofSeconds(6)).click();
        sleep(1000);
        $(SETTING_BUTTON).shouldBe(visible
                        .because("Setting button should be visible before clicking it"),
                Duration.ofSeconds(6)).click();
        return new OkChangePageTheme();
    }

    public OkChangePageTheme changeToAutoTheme() {
        SelenideElement auto = $(AUTO_THEME).shouldBe(hidden
                .because("Auto theme is a hidden list in the setting user theme"));
        executeJavaScript("arguments[0].click();", auto);
        return new OkChangePageTheme();
    }

    public OkChangePageTheme changeToLightTheme() {
        SelenideElement light = $(LIGHT_THEME).shouldBe(hidden
                .because("Light theme is a hidden list in the setting user theme"));
        executeJavaScript("arguments[0].click();", light);
        return new OkChangePageTheme();
    }

    public OkChangePageTheme changeToDarkTheme() {
        SelenideElement dark = $(DARK_THEME).shouldBe(hidden
                .because("Dark theme is a hidden list in the setting user theme"));
        executeJavaScript("arguments[0].click();", dark);
        return new OkChangePageTheme();
    }

    public OkChangePageTheme clickToolBarLogo() {
        $(TOOLBAR_LOGO_HYPERlINK).shouldBe(
                visible.because("Toolbar logo should be visible before clicking it")).click();
        return new OkChangePageTheme();
    }

    public String getThemeColorText() {
        return $(THEME_SWITCHER_CONTAINER).shouldBe(visible
                .because("Theme switcher container should be visible so we can get it's text")).getText();
    }
}
