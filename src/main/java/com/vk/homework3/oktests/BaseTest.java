package com.vk.homework3.oktests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.vk.homework3.okpages.OkLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;

import static com.codeborne.selenide.Selenide.open;
import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class BaseTest {
    static final Logger log = getLogger(lookup().lookupClass());
    protected OkLoginPage okLoginPage;


    @BeforeAll
    public static void setupClass() {
        log.info("Setup for all tests");
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://ok.ru/";
        Configuration.pageLoadTimeout = 60000;
        Configuration.timeout = 10000;

    }

    @BeforeEach
    public void setup(){
        log.info("Setup Test");
        open("/");
        okLoginPage = new OkLoginPage();
        okLoginPage.loginUsername("technopol71");
        okLoginPage.loginPassword("technopolisPassword");
        okLoginPage.submit();
    }

    @AfterEach
    public void tearDown() {
        log.info("Closing the browser");
        Selenide.closeWindow();
    }

}
