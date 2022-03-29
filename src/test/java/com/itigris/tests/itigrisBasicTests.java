package com.itigris.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Проверка элементов публичной части сайта")
public class itigrisBasicTests extends TestBase {

    //todo
    // Фактический результат: В футере itigris.com стоит 2020 год.
    // Ожидаемый результат: 2022
    @Tag("siteTests")
    @DisplayName("Проверка текстов на странице Team")
    @Test
    void searshTextElement() {
        open("/team");
        $("#header-nav").shouldHave(text("ITIGRIS"));
        $(byText("Meet Our Team")).shouldBe(visible);
        $(".my-6").shouldHave(text("Michael Khurgin"));
        $(By.linkText("info@itigris.com")).isDisplayed();
        sleep(3000);
        //$$("#the-footer").find(text("© 2022 ITigris Ltd.")).shouldBe(visible); //negative test
        $$("#the-footer").find(text("© 2020 ITigris Ltd.")).shouldBe(visible);
    }

    @Tag("siteTests")
    @DisplayName("Проверка названия в карточке кейса Essilor")
    @Test
    void searchCasesTest() {
        open("/cases");
        $(byText("Our Success Stories")).isDisplayed();
        $("[href='/cases?project=essilor']").click();
        //$$("body").find(text("Alcon")).shouldBe(visible); //negative test
        $$("body").find(text("Essilor")).shouldBe(visible);
    }

    @Tag("siteTests")
    @DisplayName("Заполнение формы обратной связи")
    @Test
    void fillFormTest() {
        open("/contact-us");
        $("input[placeholder='Enter your full name']").setValue("Olga Kos");
        $("input[placeholder='Enter your email address']").setValue("ok2304@test.test");
        $("input[placeholder='Enter your phone number']").setValue("+7921781хххх");
        $("input[placeholder='Enter your industry']").setValue("QA engineer");
        $$("span.el-checkbox__inner").last().click(); // Accept Privacy Policy
        //$x("//span[text()='SEND MESSAGE']").click();
        sleep(3000);
    }

    @Tag("marketTests")
    @DisplayName("Закрытие всплывающего окна")
    @Test
    void closeAlert() {
        Selenide.open("https://market.itigris.ru/catalog/glasses-frames");
        $("#frames-page").shouldHave(text("Каталог оправ"));
        alertWindowMethod();
    }

    @Tag("marketTests")
    @DisplayName("Поиск 1 товара")
    @Test
    void searchGlassesFramesTestDone() {
        Selenide.open("https://market.itigris.ru/catalog/glasses-frames");
        $("#frames-page").shouldHave(text("Каталог оправ"));
        $("input[placeholder='Поиск по названию']").setValue("Fixiki 7111").pressEnter();
        alertWindowMethod();
        sleep(5000);
        $$(".items-wrap").find(text("Fixiki F7111")).shouldBe(visible);
    }

    @Tag("marketTests")
    @DisplayName("Поиск нескольких товаров.")
    @ParameterizedTest(name = "Проверка результатов для запроса: \"{0}\"")
    @CsvSource(value = {
            "EYNOA| Hoya Nulux EYNOA",
            "Kids| Hoya Hilux Kids"
    }, delimiter = '|')
    void searchLeansesTest(String testData, String expectedText) {
        Selenide.open("https://market.itigris.ru/catalog/lenses");
        $("body").shouldHave(text("Каталог очковых линз"));
        alertWindowMethod();
        $("input[placeholder='Поиск по названию']").setValue(testData).pressEnter();
        $(".filters-tags").shouldHave(text("Поиск по названию: " + testData));
        $$("#container").find(text(expectedText)).shouldBe(visible);
    }

    //todo
    // Фактический результат:
    // На странице "Каталог оправ"
    // не работает поиск по брендам Enni Marco и Enni Marco Emilia
    // если наименование товара содержит > 1 слова
    @Tag("marketTests")
    @DisplayName("Поиск по части наименования.")
    @ParameterizedTest(name = "Проверка результатов для запроса: \"{0}\"")
    @CsvSource(value = {
            "Enni|Enni Marco 06-061", //done
            "Enni Marco|Enni Marco 06-061", //fail
            "Enni Marco 06-061|Enni Marco 06-061" //fail
    }, delimiter = '|')
    void searchGlassesFramesTest(String testData, String expectedText) {
        Selenide.open("https://market.itigris.ru/catalog/glasses-frames");
        $("#frames-page").shouldHave(text("Каталог оправ"));
        $("input[placeholder='Поиск по названию']").setValue(testData).pressEnter();
        alertWindowMethod();
        sleep(2000);
        $$("#container").find(text(expectedText)).shouldBe(visible);
    }
    @Disabled
    @DisplayName("Пример пропущенного теста")
    @Test
    public void skippedTest() {
        System.out.println("Тест пропущен");
    }

    void alertWindowMethod() {
        if ($x("//h3[contains(.,'ПОЛИТИКА БЕЗОПАСНОСТИ')]").is(exist)) {
            $(".el-button--danger").shouldHave(text("Принять")).click();
        }
    }
}