package com.vk.homework3.oklogics;

import com.codeborne.selenide.SelenideElement;
import com.vk.homework3.okpages.OkMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public class OkCreatePost extends OkMainPage {

    private static final By postMenuSection = By.xpath(".//a[contains(@class, 'mctc_navMenuSec ellip-menu-item ') and @data-l='t,userStatuses']");
    private static final By writePostLink = By.xpath(".//a[@class='pf-head_itx_a']");
    private static final By enterTextBox = By.xpath(".//div[@class='posting_itx emoji-tx h-mod js-ok-e js-posting-itx ok-posting-handler']");
    private static final By submitButton = By.xpath(".//button[@class='posting_submit button-pro']");
    private static final By openTopic = By.xpath(".//a[@class='media-text_a']");
    private static final By shareButton = By.xpath(".//button[@class='widget_cnt h-mod']");
    private static final By newTopicIconDown = By.xpath(".//span[@class='new_topic_icodown']");
    private static final By deletePageButton = By.xpath(".//ul[@class='u-menu']/li[3]/a[@class='u-menu_a ']");


    public OkCreatePost() {
        super();
        checkPage();
    }

    public void createPost(String enterText) {
        $(profileLink).shouldBe(visible).click();
        $(postMenuSection).shouldBe(visible).click();
        $(postMenuSection).shouldBe(visible).click();
        $(writePostLink).shouldBe(visible).click();
        $(enterTextBox).shouldBe(visible).sendKeys(enterText);
        $(submitButton).shouldBe(visible).click();
        $(openTopic).shouldBe(visible).click();
    }

    public void deletePost() {
        actions().sendKeys(Keys.ESCAPE).perform();
        SelenideElement element = $(newTopicIconDown);
        executeJavaScript("arguments[0].setAttribute('aria-expanded','true');", element);
        element.shouldBe(visible);
        SelenideElement element2 = $(deletePageButton);
        executeJavaScript("arguments[0].click();", element2);
        element2.shouldBe(hidden);
    }

    public boolean successfulCreatePost() {
        return $(shareButton).shouldBe(visible).isDisplayed();
    }
}
