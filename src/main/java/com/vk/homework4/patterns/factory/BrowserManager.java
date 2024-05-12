package com.vk.homework4.patterns.factory;

public interface BrowserManager {
    void browserURL(String url);

    void openBrowser();

    void closeBrowser();

    void browserPageLoadTimeout(int millisecond);

    void browserTimeout(int millisecond);
}
