package com.vk.homework4.patterns.factory;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.open;

public class FirefoxBrowser implements BrowserManager {

    FirefoxBrowser() {
        Configuration.browser = "firefox";
    }

    @Override
    public void browserURL(String url) {
        Configuration.baseUrl = url;
    }

    @Override
    public void openBrowser() {
        open("/");
    }

    @Override
    public void closeBrowser() {
        Selenide.closeWindow();
    }

    @Override
    public void browserPageLoadTimeout(int millisecond) {
        Configuration.pageLoadTimeout = millisecond;
    }

    @Override
    public void browserTimeout(int millisecond) {
        Configuration.timeout = millisecond;
    }
}
