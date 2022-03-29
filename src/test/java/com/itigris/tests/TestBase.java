package com.itigris.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    @BeforeEach
    public void beforeEach() {
        String browser = System.getProperty("browser", "chrome");
        String size = System.getProperty("size", "1920x1080");

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = size;
        Configuration.browser = browser;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        Attach.attachAsText("Browser: ", browser);
        Attach.attachAsText("Size: ", size);

        clearBrowserCookies();
        Configuration.baseUrl = "https://itigris.com";
        open("");
    }

    @AfterEach
    @DisplayName("Формирование артефактов тестирования")
    void addAttachment() {
        Attach.screenshotAs("Last screenshot");
        Attach.addVideo();
        Attach.pageSource();
        Attach.browserConsoleLogs();
    }

    /*
    @AfterEach
    @DisplayName("Завершение работы браузера")
    void closeBrowser() {
        closeWebDriver();
    }
*/

    @AfterAll
    @DisplayName("Завершение работы браузера")
    public static void afterAll() {
        closeWebDriver();
    }
}
