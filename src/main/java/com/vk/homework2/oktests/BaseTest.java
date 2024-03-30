package com.vk.homework2.oktests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void setupClass(){
        Configuration.browser ="chrome";
        Configuration.baseUrl = "https://ok.ru/";
    }

}
