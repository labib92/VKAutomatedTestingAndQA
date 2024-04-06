package com.vk.homework3.oktests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class BaseTest {
    static final Logger log = getLogger(lookup().lookupClass());

    @BeforeAll
    public static void setupClass() {
        log.info("Setup for all tests");
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://ok.ru/";
        Configuration.pageLoadTimeout = 60000;
        Configuration.timeout = 10000;
    }

}
