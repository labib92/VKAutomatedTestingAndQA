package com.vk.homework4.oktests;

import com.vk.homework4.okpages.OkLogout;
import com.vk.homework4.patterns.decorator.OkCreateGroup;
import com.vk.homework4.patterns.decorator.OkDecoratorGroup;
import com.vk.homework4.patterns.decorator.OkEventDecorator;
import com.vk.homework4.patterns.decorator.OkGroupByInterestDecorator;
import com.vk.homework4.patterns.decorator.OkPlainGroup;
import com.vk.homework4.patterns.decorator.OkPublicOrBusinessGroupDecorator;
import com.vk.homework4.patterns.object.EventValueObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.TimeUnit;

@DisplayName("Ok.ru Create Group Test Class")
public class OkCreateGroupTest extends BaseTest {
    private OkCreateGroup createGroup;

    @AfterEach
    @Override
    public void tearDown() {
        log.info("Deleting the group");
        createGroup.deleteGroup();
        log.info("Logout from test change after changing the theme");
        OkLogout okLogout = new OkLogout();
        okLogout.logoutSuccess();
    }

    @AfterAll
    public static void close() {
        log.info("Close Browser after finishing create group test");
        browserManager.closeBrowser();
    }

    @ParameterizedTest
    @CsvSource("Labib's Group by Interest")
    @DisplayName("test create group by interest")
    @Tag("createGroupByInterest")
    @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
    public void testCreateGroupByInterest(String groupName) {
        createGroup = new OkGroupByInterestDecorator(new OkDecoratorGroup(new OkPlainGroup()), groupName);
        log.info("Creating Group by Interest {}", groupName);
        createGroup.createGroup();
        Assertions.assertEquals(createGroup.getGroupNameHeader().getText(), groupName,
                "The group tittle should be " + groupName + " after creating the group");
    }

    @Nested
    @DisplayName("Ok.ru Create Another Group Test Nested Class")
    class OkCreateAnotherGroupTest {

        @ParameterizedTest
        @CsvSource("Labib's Public Or Business Group")
        @DisplayName("test create public or business group")
        @Tag("createBusinessOrPublicGroup")
        @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
        public void testCreatePublicOrBusinessGroup(String groupName) {
            createGroup = new OkPublicOrBusinessGroupDecorator(new OkDecoratorGroup(new OkPlainGroup()), groupName);
            log.info("Creating Public Or Business Group {}", groupName);
            createGroup.createGroup();
            Assertions.assertEquals(createGroup.getGroupNameHeader().getText(), groupName,
                    "The group tittle should be " + groupName + " after creating the group");
        }

        @Nested
        @DisplayName("Ok.ru Create Event Test Nested Class")
        class OkCreateEventTest {

            @ParameterizedTest
            @CsvSource("Labib's Event, Nevsky District, 777777777, ok.ru")
            @DisplayName("test create event")
            @Tag("createEvent")
            @Timeout(value = 40000, unit = TimeUnit.MILLISECONDS)
            public void testCreateEvent(String eventName, String address, String phoneNumber, String websiteAddress) {
                createGroup = new OkEventDecorator(new OkDecoratorGroup(new OkPlainGroup()),
                        new EventValueObject(eventName, address, phoneNumber, websiteAddress));
                log.info("Creating event {}", eventName);
                createGroup.createGroup();
                Assertions.assertEquals(createGroup.getGroupNameHeader().getText(), eventName,
                        "The group tittle should be " + eventName + " after creating the group");
            }
        }
    }
}
