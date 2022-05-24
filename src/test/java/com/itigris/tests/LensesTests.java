package com.itigris.tests;

import com.itigris.pages.LensesPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LensesTests extends TestBase {

    LensesPage lensesPage = new LensesPage();

    String url = "https://market.itigris.ru/catalog/lenses";

    @Tag("marketTests")
    @DisplayName("Поиск нескольких товаров.")
    @ParameterizedTest(name = "Проверка результатов для запроса: \"{0}\"")
    @CsvSource(value = {
            "EYNOA| Hoya Nulux EYNOA",
            "Kids| Hoya Hilux Kids"
    }, delimiter = '|')
    void searchLeansesTest(String testData, String expectedText) {
        open(url);
        lensesPage.checkTextHeader();
        alertWindowMethod();
        $("input[placeholder='Поиск по названию']").setValue(testData).pressEnter();
        $(".filters-tags").shouldHave(text("Поиск по названию: " + testData));
        assertTrue($("#container").shouldHave(text(expectedText)).isDisplayed());
    }

    void alertWindowMethod() {
        if ($x("//h3[contains(.,'ПОЛИТИКА БЕЗОПАСНОСТИ')]").is(exist)) {
            $(".el-button--danger").shouldHave(text("Принять")).click();
        }
    }
}