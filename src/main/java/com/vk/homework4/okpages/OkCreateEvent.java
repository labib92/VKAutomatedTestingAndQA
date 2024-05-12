package com.vk.homework4.okpages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkCreateEvent extends OkBaseCreateGroup {
    private static final By EVENT_GROUP = By.xpath(".//a[@data-l='t,HAPPENING']");
    private static final By EVENT_CATEGORY = By.xpath(".//div[@data-module='multi-select/MultiSelect']");
    private static final By CITY_CATEGORY = By.xpath(".//div[@data-module='CityMultiSelect']");
    private static final By ADDRESS_FIELD = By.xpath(".//input[@id='field_address']");
    private static final By PHONE_NUMBER = By.xpath(".//input[@id='field_phone']");
    private static final By FIELD_WEBSITE = By.xpath(".//input[@id='field_website']");

    public OkCreateEvent() {
        super();
    }

    public void clickEventGroup() {
        $(EVENT_GROUP).should(visible
                .because("Event group should be visible before clicking it")).click();
    }

    @Override
    public void clickGroupCategory() {
        $(EVENT_CATEGORY).shouldBe(visible
                .because("Event category should be visible before clicking it")).click();
    }

    public void clickCityCategory() {
        $(CITY_CATEGORY).shouldBe(visible
                .because("City category should be visible before clicking it")).click();
    }

    public void inputAddress(String address) {
        $(ADDRESS_FIELD).shouldBe(visible
                .because("Address field should be visible before inputting the address text")).sendKeys(address);
    }

    public void inputPhoneNumber(String phoneNumber) {
        $(PHONE_NUMBER).shouldBe(visible
                .because("Phone number field should be visible before inputting the number")).sendKeys(phoneNumber);
    }

    public void inputWebsiteAddress(String websiteAddress) {
        $(FIELD_WEBSITE).shouldBe(visible
                .because("Website address should be visible before inputting the address")).sendKeys(websiteAddress);
    }
}
