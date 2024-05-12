package com.vk.homework4.patterns.decorator;

import com.codeborne.selenide.SelenideElement;
import com.vk.homework4.okpages.OkCreateEvent;
import com.vk.homework4.patterns.element.CityCategoryPageElement;
import com.vk.homework4.patterns.element.EventCategoryPageElement;
import com.vk.homework4.patterns.element.GroupAccessRadioButtonsPageElement;
import com.vk.homework4.patterns.object.EventValueObject;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkEventDecorator extends OkDecoratorGroup {
    private OkCreateEvent createEvent;
    private final EventValueObject eventValueObject;

    public OkEventDecorator(OkCreateGroup decoratedGroup, EventValueObject eventValueObject) {
        super(decoratedGroup);
        this.eventValueObject = eventValueObject;
    }

    @Override
    public void createGroup() {
        createEvent();
        super.decoratedGroup.createGroup();
    }

    private void createEvent() {
        createEvent = new OkCreateEvent();
        EventCategoryPageElement eventPageElement = new EventCategoryPageElement();
        CityCategoryPageElement cityPageElement = new CityCategoryPageElement();
        groupAccessRadioButtonsPageElement = new GroupAccessRadioButtonsPageElement();
        createEvent.clickNavigateSideGroupButton();
        createEvent.clickGroupCatalogHeaderButton();
        createEvent.clickEventGroup();
        createEvent.inputGroupName(eventValueObject.getEventName());
        createEvent.clickGroupCategory();
        eventPageElement.selectLectureCategory();
        groupAccessRadioButtonsPageElement.selectClosedAccessGroupRadioButton();
        createEvent.clickCityCategory();
        cityPageElement.selectSaintPetersburgCity();
        createEvent.inputAddress(eventValueObject.getEventAddress());
        createEvent.inputPhoneNumber(eventValueObject.getEventPhoneNumber());
        createEvent.inputWebsiteAddress(eventValueObject.getEventWebsite());
    }

    @Override
    public SelenideElement getGroupNameHeader() {
        return $(createEvent.getGroupNameHeader()).shouldBe(visible
                .because("Group name header should be visible"));
    }
}
