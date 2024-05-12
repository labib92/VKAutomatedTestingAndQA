package com.vk.homework4.okpages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkCreateGroupByInterest extends OkBaseCreateGroup {
    private static final By GROUP_BY_INTEREST = By.xpath(".//a[@data-l='t,INTEREST']");

    public OkCreateGroupByInterest() {
        super();
    }

    public void clickGroupByInterest() {
        $(GROUP_BY_INTEREST).shouldBe(visible
                .because("Group by interest should be visible before clicking it")).click();
    }
}
