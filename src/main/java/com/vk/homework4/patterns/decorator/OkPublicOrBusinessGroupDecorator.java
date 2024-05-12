package com.vk.homework4.patterns.decorator;

import com.codeborne.selenide.SelenideElement;
import com.vk.homework4.okpages.OkCreatePublicOrBusinessGroup;
import com.vk.homework4.patterns.element.GroupAccessRadioButtonsPageElement;
import com.vk.homework4.patterns.element.GroupCategoryPageElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkPublicOrBusinessGroupDecorator extends OkDecoratorGroup {
    private OkCreatePublicOrBusinessGroup createGroup;
    private final String groupName;

    public OkPublicOrBusinessGroupDecorator(OkCreateGroup decoratedGroup, String groupName) {
        super(decoratedGroup);
        this.groupName = groupName;
    }

    @Override
    public void createGroup() {
        createBusinessOrPublicGroup();
        super.decoratedGroup.createGroup();
    }

    private void createBusinessOrPublicGroup() {
        createGroup = new OkCreatePublicOrBusinessGroup();
        groupCategoryPageElement = new GroupCategoryPageElement();
        groupAccessRadioButtonsPageElement = new GroupAccessRadioButtonsPageElement();
        createGroup.clickNavigateSideGroupButton();
        createGroup.clickGroupCatalogHeaderButton();
        createGroup.clickPublicOrBusinessGroup();
        createGroup.inputGroupName(groupName);
        createGroup.clickGroupCategory();
        groupCategoryPageElement.selectFoodCategory();
        groupAccessRadioButtonsPageElement.selectSecretAccessGroupRadioButton();
    }

    @Override
    public SelenideElement getGroupNameHeader() {
        return $(createGroup.getGroupNameHeader()).shouldBe(visible
                .because("Group name header should be visible"));
    }
}
