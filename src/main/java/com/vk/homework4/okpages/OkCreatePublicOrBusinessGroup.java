package com.vk.homework4.okpages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkCreatePublicOrBusinessGroup extends OkBaseCreateGroup {

    private static final By PUBLIC_OR_BUSINESS = By.xpath(".//a[@data-l='t,PAGE']");

    public OkCreatePublicOrBusinessGroup() {
        super();
    }

    public void clickPublicOrBusinessGroup() {
        $(PUBLIC_OR_BUSINESS).shouldBe(visible
                .because("Public or Business group should be visible before clicking it")).click();
    }
}
