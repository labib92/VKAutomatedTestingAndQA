package com.vk.homework3.okpages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OkMainPage {
    protected static final By navigatorSideUserPageButton = By.xpath(".//a[contains(@class, 'nav-side_i  __with-ic __with-new-icons') and @data-l='t,userPage']");
    protected static final By profileLink = By.xpath(".//a[@class='nav-side_i  __with-ic __with-new-icons']");
    protected static final By profileSettingsButton = By.xpath(".//button[@class='ucard-mini toolbar_ucard js-toolbar-menu __a11y']");
    protected static final By toolbarButton = By.xpath(".//button[@class='toolbar_nav_a toolbar_nav_a__vk_ecosystem __a11y']");
    protected static final By searchSiteInput = By.xpath(".//input[@class='input__prt1l __size-m__prt1l input__mofy2 input-field__on39s __right-icon__on39s __white-toolbar__on39s']");

    public OkMainPage() {
        open("/");
    }

    protected void checkPage() {
        $(navigatorSideUserPageButton).shouldBe(visible);
        $(profileLink).shouldBe(visible);
        $(profileSettingsButton).shouldBe(visible);
        $(toolbarButton).shouldBe(visible);
        $(searchSiteInput).shouldBe(visible);
    }
}
