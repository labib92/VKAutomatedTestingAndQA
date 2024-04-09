package com.vk.homework3.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.homework3.oklogics.OkChangePageTheme;
import com.vk.homework3.oklogics.OkLogout;
import com.vk.homework3.okpages.OkLoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

@DisplayName("Ok change page theme class")
public class OkChangePageThemeTest extends BaseTest {
    private OkChangePageTheme okChangePageTheme;

    @BeforeEach
    public void setup() {
        log.info("Setup change page theme test");
        OkLoginPage okLoginPage = new OkLoginPage();
        //Enter username and password
        okLoginPage.login("user", "password");
        okChangePageTheme = new OkChangePageTheme();
    }

    @AfterEach
    public void tearDown() {
        log.info("Logout from test change theme to dark");
        OkLogout okLogout = new OkLogout();
        okLogout.logoutSuccess();
    }

    @AfterAll
    public static void close() {
        Selenide.closeWindow();
    }

    @Test
    @DisplayName("Test change page theme to dark theme")
    @Tag("DarkTheme")
    @Timeout(value = 20000, unit = TimeUnit.MILLISECONDS)
    public void testChangeThemeToDark() {
        log.info("Test Change Theme to Dark");
        okChangePageTheme.navigateToSettingsMenu();
        okChangePageTheme.changeToDarkTheme();
        Assertions.assertAll("Setting Elements",
                () -> Assertions.assertTrue(okChangePageTheme.checkSettingFriendButton(), "Button friend doesn't exist"),
                () -> Assertions.assertTrue(okChangePageTheme.checkSettingPhotoButton(), "Button photo doesn't exist"));
    }

    @DisplayName("Ok change page to another theme nested class")
    @Nested
    class OkChangePageToAnotherTheme {

        @Test
        @DisplayName("Test change page theme to light theme")
        @Tag("LightTheme")
        @Timeout(value = 20000, unit = TimeUnit.MILLISECONDS)
        public void testChangeThemeToLight() {
            log.info("Test Change Theme to Light");
            okChangePageTheme.navigateToSettingsMenu();
            okChangePageTheme.changeToLightTheme();
            Assertions.assertAll("Setting Elements",
                    () -> Assertions.assertTrue(okChangePageTheme.checkSettingFriendButton(), "Button friend doesn't exist"),
                    () -> Assertions.assertTrue(okChangePageTheme.checkSettingPhotoButton(), "Button photo doesn't exist"));
        }

        @DisplayName("Ok change page to system theme nested class")
        @Nested
        class OkChangeThemeToSystemTheme {
            @Test
            @DisplayName("Test change page theme to system theme")
            @Tag("SystemTheme")
            @Timeout(value = 20000, unit = TimeUnit.MILLISECONDS)
            public void testChangeThemeToSystem() {
                log.info("Test Change Theme to System");
                okChangePageTheme.navigateToSettingsMenu();
                okChangePageTheme.changeToAutoTheme();
                Assertions.assertAll("Setting Elements",
                        () -> Assertions.assertTrue(okChangePageTheme.checkSettingFriendButton(), "Button friend doesn't exist"),
                        () -> Assertions.assertTrue(okChangePageTheme.checkSettingPhotoButton(), "Button photo doesn't exist"));
            }
        }
    }
}
