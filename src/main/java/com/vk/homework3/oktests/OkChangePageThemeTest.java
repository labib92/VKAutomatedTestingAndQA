package com.vk.homework3.oktests;

import com.codeborne.selenide.Selenide;
import com.vk.homework3.okpages.OkChangePageTheme;
import com.vk.homework3.okpages.OkLogout;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

@DisplayName("Ok change page theme class")
public class OkChangePageThemeTest extends BaseTest {
    private OkChangePageTheme okChangePageTheme;

    @AfterEach
    @Override
    public void tearDown() {
        log.info("Logout from test change after changing the theme");
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
        okChangePageTheme = new OkChangePageTheme();
        okChangePageTheme.navigateToSettingsMenu();
        okChangePageTheme.changeToDarkTheme();
        okChangePageTheme.clickToolBarLogo();
        okChangePageTheme.navigateToSettingsMenu();
        Assertions.assertEquals(okChangePageTheme.getThemeColorText(), "Тёмная",
                "The theme text should be Тёмная after changing the theme to dark theme");
    }

    @DisplayName("Ok change page to another theme nested class")
    @Nested
    class OkChangePageToAnotherTheme {

        @Test
        @DisplayName("Test change page theme to light theme")
        @Tag("LightTheme")
        @Timeout(value = 20000, unit = TimeUnit.MILLISECONDS)
        public void testChangeThemeToLight() {
            okChangePageTheme = new OkChangePageTheme();
            okChangePageTheme.navigateToSettingsMenu();
            okChangePageTheme.changeToLightTheme();
            okChangePageTheme.clickToolBarLogo();
            okChangePageTheme.navigateToSettingsMenu();
            Assertions.assertEquals(okChangePageTheme.getThemeColorText(), "Светлая",
                    "The theme text should be Светлая after changing the theme to light theme");
        }

        @DisplayName("Ok change page to system theme nested class")
        @Nested
        class OkChangeThemeToSystemTheme {
            @Test
            @DisplayName("Test change page theme to system theme")
            @Tag("SystemTheme")
            @Timeout(value = 20000, unit = TimeUnit.MILLISECONDS)
            public void testChangeThemeToSystem() {
                okChangePageTheme = new OkChangePageTheme();
                okChangePageTheme.navigateToSettingsMenu();
                okChangePageTheme.changeToAutoTheme();
                okChangePageTheme.clickToolBarLogo();
                okChangePageTheme.navigateToSettingsMenu();
                Assertions.assertEquals(okChangePageTheme.getThemeColorText(), "Как в системе",
                        "The theme text should be Как в системе after changing the theme to system theme");
            }
        }
    }
}
