package com.vk.homework2.oklogics;

import com.vk.homework2.okpages.OkMainPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkAddFriend extends OkMainPage {
    private final By searchSiteInput = By.xpath("//input[@class='input__prt1l __size-m__prt1l input__mofy2 input-field__on39s __right-icon__on39s __white-toolbar__on39s']");
    private final By tabUsersButton = By.xpath("//button[@id='tab-users']");
    private final By addFriendButton = By.xpath("//button[@class='button__pe9qo button-core-container__0ej09']");
    public OkAddFriend(){
        super();
    }

    public void addFriend(String friendName){
       $(searchSiteInput).shouldBe(visible).sendKeys(friendName);
       $(searchSiteInput).pressEnter();
       $(tabUsersButton).shouldBe(visible).click();
       $(addFriendButton).shouldBe(visible).click();
    }
}
