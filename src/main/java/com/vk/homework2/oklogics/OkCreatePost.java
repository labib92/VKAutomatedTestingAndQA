package com.vk.homework2.oklogics;

import com.vk.homework2.okpages.OkMainPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkCreatePost extends OkMainPage {

    private final By profileLink = By.xpath("//a[@class='nav-side_i  __with-ic __with-new-icons']");
    private final By postMenuSection = By.xpath("//a[contains(@class, 'mctc_navMenuSec ellip-menu-item ') and @data-l='t,userStatuses']");
    private final By writePostLink = By.xpath("//a[@class='pf-head_itx_a']");
    private final By enterTextBox= By.xpath("//div[@class='posting_itx emoji-tx h-mod js-ok-e js-posting-itx ok-posting-handler']");
    private final By shareButton = By.xpath("//button[@class='posting_submit button-pro']");

    public OkCreatePost(){
        super();
    }

    public void createPost(String enterText) {
        $(profileLink).shouldBe(visible).click();
        $(postMenuSection).shouldBe(visible).click();
        $(writePostLink).shouldBe(visible).click();
        $(enterTextBox).shouldBe(visible).sendKeys(enterText);
        $(shareButton).shouldBe(visible).click();
    }
}
