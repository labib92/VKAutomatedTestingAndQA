package com.vk.homework3.okpages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkMainPage {
    protected static final By NAVIGATOR_SIDE_USER_PAGE_HYPERLINK = By.xpath(".//a[@data-l='t,userPage']");
    protected static final By NAVIGATOR_SIDE_GROUP_PAGE_HYPERLINK = By.xpath(".//a[@data-l='t,userAltGroup']");
    protected static final By PROFILE_SETTINGS_BUTTON = By.xpath(".//button[@class='ucard-mini toolbar_ucard js-toolbar-menu __a11y']");
    protected static final By TOOLBAR_BUTTON = By.xpath(".//button[@class='toolbar_nav_a toolbar_nav_a__vk_ecosystem __a11y']");
    protected static final By SEARCH_SITE_INPUT = By.xpath(".//input[@class='input__prt1l __size-m__prt1l input__mofy2 input-field__on39s __right-icon__on39s __white-toolbar__on39s']");


    public OkMainPage() {
        checkPage();
    }

    protected void checkPage() {
        $(PROFILE_SETTINGS_BUTTON).shouldBe(visible);
        $(TOOLBAR_BUTTON).shouldBe(visible);
        $(SEARCH_SITE_INPUT).shouldBe(visible);
    }
}
