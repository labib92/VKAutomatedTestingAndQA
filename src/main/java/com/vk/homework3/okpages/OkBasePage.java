package com.vk.homework3.okpages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkBasePage {
    protected static final By NAVIGATOR_SIDE_USER_PAGE_HYPERLINK = By.xpath(".//a[@data-l='t,userPage']");
    protected static final By NAVIGATOR_SIDE_GROUP_PAGE_HYPERLINK = By.xpath(".//a[@data-l='t,userAltGroup']");
    protected static final By MESSAGE_TOOLBAR_BUTTON = By.xpath(".//button[@id='msg_toolbar_button']");
    protected static final By PROFILE_SETTINGS_BUTTON = By.xpath(".//button[@class='ucard-mini toolbar_ucard js-toolbar-menu __a11y']");
    protected static final By TOOLBAR_BUTTON = By.xpath(".//button[@class='toolbar_nav_a toolbar_nav_a__vk_ecosystem __a11y']");
    protected static final By NOTIFICATION_TOOLBAR_BUTTON = By.xpath(".//button[@id='ntf_toolbar_button']");

    public OkBasePage() {
        checkPage();
    }

    protected void checkPage() {
        $(NOTIFICATION_TOOLBAR_BUTTON).shouldBe(visible);
        $(TOOLBAR_BUTTON).shouldBe(visible);
        $(MESSAGE_TOOLBAR_BUTTON).shouldBe(visible);
    }
}
