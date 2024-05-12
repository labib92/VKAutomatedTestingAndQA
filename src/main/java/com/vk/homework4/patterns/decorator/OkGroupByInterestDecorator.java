package com.vk.homework4.patterns.decorator;

import com.codeborne.selenide.SelenideElement;
import com.vk.homework4.okpages.OkCreateGroupByInterest;
import com.vk.homework4.patterns.element.GroupAccessRadioButtonsPageElement;
import com.vk.homework4.patterns.element.GroupCategoryPageElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkGroupByInterestDecorator extends OkDecoratorGroup {
    private OkCreateGroupByInterest createGroup;
    private final String groupName;

    public OkGroupByInterestDecorator(OkCreateGroup decoratedGroup, String groupName) {
        super(decoratedGroup);
        this.groupName = groupName;
    }

    @Override
    public void createGroup() {
        createGroupByInterest();
        super.decoratedGroup.createGroup();
    }

    private void createGroupByInterest() {
        createGroup = new OkCreateGroupByInterest();
        groupCategoryPageElement = new GroupCategoryPageElement();
        groupAccessRadioButtonsPageElement = new GroupAccessRadioButtonsPageElement();
        createGroup.clickNavigateSideGroupButton();
        createGroup.clickGroupCatalogHeaderButton();
        createGroup.clickGroupByInterest();
        createGroup.inputGroupName(groupName);
        createGroup.clickGroupCategory();
        groupCategoryPageElement.selectCarCategory();
        groupAccessRadioButtonsPageElement.selectClosedAccessGroupRadioButton();
    }

    @Override
    public SelenideElement getGroupNameHeader() {
        return $(createGroup.getGroupNameHeader()).shouldBe(visible);
    }
}
