package com.vk.homework2.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.homework2.oklogics.OkLogout;
import com.vk.homework2.okpages.OkLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OkLogoutTest extends BaseTest{
    private OkLogout okLogout;

    @BeforeEach
    public void setup(){
        OkLoginPage okLoginPage = new OkLoginPage();
        //Enter username and password
        okLoginPage.login("user", "password");
        okLogout =  new OkLogout();
    }

    @AfterEach
    public void tearDown(){
        Selenide.closeWindow();
    }

    @Test
    public void testLogout()  {
        okLogout.logoutSuccess();
        Assertions.assertTrue(okLogout.logoutSuccessCheck(), "Logout failed");
    }
}
