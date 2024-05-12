package com.vk.homework4.patterns.factory;

public class BrowserManagerFactory {

    public static BrowserManager getBrowserType(BrowserType browserType) {
        BrowserManager browserManager;

        switch (browserType) {
            case CHROME:
                browserManager = new ChromeBrowser();
                break;
            case FIREFOX:
                browserManager = new FirefoxBrowser();
                break;
            default:
                throw new IllegalArgumentException("Browser type is not found");
        }
        return browserManager;
    }
}
