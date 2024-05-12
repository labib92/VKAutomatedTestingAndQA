package com.vk.homework4.patterns.object;

public class EventValueObject {
    private final String eventName;
    private final String eventAddress;
    private final String eventPhoneNumber;
    private final String eventWebsite;

    public EventValueObject(String eventName, String eventAddress, String eventPhoneNumber, String eventWebsite) {
        this.eventName = eventName;
        this.eventAddress = eventAddress;
        this.eventPhoneNumber = eventPhoneNumber;
        this.eventWebsite = eventWebsite;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public String getEventPhoneNumber() {
        return eventPhoneNumber;
    }

    public String getEventWebsite() {
        return eventWebsite;
    }
}
