package com.vk.homework4.patterns.decorator;

import com.codeborne.selenide.SelenideElement;
import com.vk.homework4.patterns.element.GroupAccessRadioButtonsPageElement;
import com.vk.homework4.patterns.element.GroupCategoryPageElement;

public class OkDecoratorGroup implements OkCreateGroup {
    protected final OkCreateGroup decoratedGroup;
    protected GroupCategoryPageElement groupCategoryPageElement;
    protected GroupAccessRadioButtonsPageElement groupAccessRadioButtonsPageElement;

    public OkDecoratorGroup(OkCreateGroup decoratedGroup) {
        this.decoratedGroup = decoratedGroup;
    }

    @Override
    public void createGroup() {
        decoratedGroup.createGroup();
    }

    @Override
    public void deleteGroup() {
        decoratedGroup.deleteGroup();
    }

    @Override
    public SelenideElement getGroupNameHeader() {
        return decoratedGroup.getGroupNameHeader();
    }
}
