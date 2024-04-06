package com.vk.homework3.oklogics;

import com.codeborne.selenide.SelenideElement;
import com.vk.homework3.okpages.OkMainPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class OkAddFriend extends OkMainPage {

    private static final By tabUsersButton = By.xpath(".//button[@id='tab-users']");
    private static final By addFriendButton = By.xpath(".//button[@class='button__pe9qo button-core-container__0ej09']");
    private static final By navigatorSideUserPageButton = By.xpath(".//a[contains(@class, 'nav-side_i  __with-ic __with-new-icons') and @data-l='t,userPage']");
    private static final By navigatorSideFriendButton = By.xpath(".//a[contains(@class, 'nav-side_i  __with-ic __with-new-icons') and @data-l='t,userFriend']");
    private static final By moreButton = By.xpath(".//button[@id='mctc_navMenuDDC_userFriendMenuMore']");
    private static final By outgoingRequestsButton = By.xpath(".//a[contains(@class,'mctc_navMenuDDLIL') and @data-l='t,userOutgoingFriendRequest']");
    private static final By declineFriendRequestButton = By.xpath(".//button[contains(@class, 'js-entity-decline button-pro __sec __small') or contains(text(), 'Отменить заявку')]");


    public OkAddFriend() {
        super();
        checkPage();
    }

    public void addFriend(String friendName) {
        $(searchSiteInput).shouldBe(visible).sendKeys(friendName);
        $(searchSiteInput).pressEnter();
        $(tabUsersButton).shouldBe(visible).click();
        $(addFriendButton).shouldBe(visible).click();
    }

    public void deleteFriend() {
        $(navigatorSideFriendButton).shouldBe(visible).click();
        SelenideElement element = $(moreButton);
        executeJavaScript("arguments[0].setAttribute('aria-expanded','true');", element);
        element.shouldBe(visible);
        SelenideElement element2 = $(outgoingRequestsButton);
        executeJavaScript("arguments[0].click();", element2);
        element2.shouldBe(hidden);
        $(declineFriendRequestButton).shouldBe(visible).doubleClick();
    }

    public boolean checkAddFriend() {
        return $(navigatorSideUserPageButton).shouldBe(visible).isDisplayed();
    }
}
