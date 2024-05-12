package com.vk.homework4.okpages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkBaseCreateGroup extends OkBasePage {
    protected static final By GROUP_CATALOG_HEADER_BUTTON = By.xpath(".//a[@class='groups-catalog-header_button button-pro ml-2x']");
    protected static final By GROUP_NAME_INPUT = By.xpath(".//input[@id='field_name']");
    protected static final By GROUP_CATEGORY = By.xpath(".//div[@class='multi-select_it_cnt']");
    protected static final By GROUP_NAME_HEADER = By.xpath(".//h1[@class='group-name_h']");

    public OkBaseCreateGroup() {
        super();
    }

    public void clickNavigateSideGroupButton() {
        $(NAVIGATOR_SIDE_GROUP_PAGE_HYPERLINK).shouldBe(visible
                .because("Navigator side group page should be visible before clicking it")).click();
    }

    public void clickGroupCatalogHeaderButton() {
        $(GROUP_CATALOG_HEADER_BUTTON).shouldBe(visible
                .because("Group catalog header should be visible before clicking it")).click();
    }

    public void inputGroupName(String groupName) {
        $(GROUP_NAME_INPUT).shouldBe(visible
                .because("Group name input should be visible before typing the group name")).type(groupName);
    }

    public void clickGroupCategory() {
        $(GROUP_CATEGORY).shouldBe(visible
                .because("Group category button should be visible before clicking it")).click();
    }

    public By getGroupNameHeader() {
        return GROUP_NAME_HEADER;
    }
}
