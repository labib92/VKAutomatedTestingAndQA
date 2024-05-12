package com.vk.homework4.okpages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;

public class OkCreatePost extends OkBasePage {
    private static final By POST_DROPDOWN_BUTTON = By.xpath(".//button[@class = 'dropdown-button__qx55h']");
    private static final By RECORD_HYPERLINK = By.xpath(".//a[@class = 'link__91azp item-link__7e56q __primary__91azp']");
    private static final By SHARE_BUTTON = By.xpath(".//button[@class = 'posting_submit button-pro']");
    private static final By POSTS_HYPERLINK = By.xpath(".//a[@data-l='t,userStatuses']");
    private static final By NEW_TOPIC_ICON_DOWN_SPAN = By.xpath(".//span[@class='new_topic_icodown']");
    private static final By DELETE_PAGE_BUTTON = By.xpath(".//ul[@class='u-menu']/li[3]/a[@class='u-menu_a ']");
    private static final By POST_TEXT_DIV = By.xpath(".//div[@class='media-text_cnt_tx emoji-tx textWrap']");

    public OkCreatePost() {
        super();
    }

    public void createPost(String enterText) {
        sleep(1000);
        $(POST_DROPDOWN_BUTTON).shouldBe(visible
                        .because("The post dropdown button should be visible before clicking"),
                Duration.ofSeconds(6)).click();
        $(RECORD_HYPERLINK).shouldBe(visible
                        .because("The record hyperlink button should be visible before clicking"),
                Duration.ofSeconds(6)).click();
        sleep(1000);
        try {
            typeString(enterText);
        } catch (AWTException e) {
            System.err.println(e.getMessage());
        }
        $(SHARE_BUTTON).shouldBe(visible
                        .because("We can't click on the button to create post if it's not visible"),
                Duration.ofSeconds(6)).click();
        $(NAVIGATOR_SIDE_USER_PAGE_HYPERLINK).shouldBe(visible
                        .because("The button should be visible before clicking"),
                Duration.ofSeconds(6)).click();
        $(POSTS_HYPERLINK).shouldBe(visible
                        .because("The button should be visible before clicking"),
                Duration.ofSeconds(6)).click();
    }

    public void deletePost() {
        SelenideElement element = $(NEW_TOPIC_ICON_DOWN_SPAN).shouldBe(visible
                .because("New topic icon down should be visible"));
        executeJavaScript("arguments[0].setAttribute('aria-expanded','true');", element);
        SelenideElement element2 = $(DELETE_PAGE_BUTTON).shouldBe(hidden
                .because("Delete page button should be hidden"), Duration.ofSeconds(10));
        executeJavaScript("arguments[0].click();", element2);
    }

    public SelenideElement successfulCreatePost() {
        return $(POST_TEXT_DIV).shouldBe(visible
                .because("After creating the post the post should be visible"));
    }

    private static void typeString(String string) throws AWTException {
        Robot robot = new Robot();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isUpperCase(c)) {
                robot.keyPress(KeyEvent.VK_SHIFT);
            }

            robot.keyPress(Character.toUpperCase(c));
            robot.keyRelease(Character.toUpperCase(c));

            if (Character.isUpperCase(c)) {
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
        }
    }
}
