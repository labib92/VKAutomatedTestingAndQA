package com.vk.homework4.oktests;

import com.vk.homework4.patterns.factory.BrowserManager;
import com.vk.homework4.patterns.factory.BrowserManagerFactory;
import com.vk.homework4.patterns.factory.BrowserType;
import com.vk.homework4.okpages.OkLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class BaseTest {
    static final Logger log = getLogger(lookup().lookupClass());
    protected static BrowserManager browserManager;
    protected OkLoginPage okLoginPage;

    @BeforeAll
    public static void setupClass() {
        log.info("Setup for all tests");
        browserManager = BrowserManagerFactory.getBrowserType(BrowserType.CHROME);
        browserManager.browserURL("https://ok.ru/");
        browserManager.browserPageLoadTimeout(60000);
        browserManager.browserTimeout(10000);
    }

    @BeforeEach
    public void setup() {
        log.info("Setup Test");
        browserManager.openBrowser();
        okLoginPage = new OkLoginPage();
        log.info("Entering username");
        okLoginPage.loginUsername("technopol71");
        log.info("Entering password");
        okLoginPage.loginPassword("technopolisPassword");
        log.info("Clicking on submit button");
        okLoginPage.submit();
    }

    @AfterEach
    public void tearDown() {
        log.info("Closing the browser");
        browserManager.closeBrowser();
    }
}
