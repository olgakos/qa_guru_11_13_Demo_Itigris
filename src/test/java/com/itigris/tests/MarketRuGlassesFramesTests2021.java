package com.itigris.tests;

import com.itigris.pages.GlassesFramesPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MarketRuGlassesFramesTests2021 extends TestBase {

    GlassesFramesPage framesPage = new GlassesFramesPage();

    String url = "https://market.itigris.ru/catalog/glasses-frames";
    String goods = "Fixiki F7111";

    @Test
    @Tag("marketTests")
    @DisplayName("Поиск 1 товара")
    void searchGlassesFramesTestDone() {
        open(url);
        framesPage.checkTextHeader();
        alertWindowMethod();
        framesPage.setGoodsInput(goods);
        framesPage.checkGoodsSearch();
    }

    @Test
    @Tag("marketTests")
    @DisplayName("Закрытие всплывающего окна")
    void closeAlert() {
        open(url);
        framesPage.checkTextHeader();
        alertWindowMethod();
    }

    @Tag("marketTests")
    @DisplayName("Пример нахождения бага: поиск по части наименования.")
    @ParameterizedTest(name = "Проверка результатов для запроса: \"{0}\"")
    @CsvSource(value = {
            //"Enni|Enni Marco 06-061", //done
            "Enni Marco|Enni Marco 06-061", //fail
            "Enni Marco 06-061|Enni Marco 06-061" //fail
    }, delimiter = '|')
    void searchGlassesFramesTest(String testData, String expectedText) {
        open(url);
        framesPage.checkTextHeader();
        alertWindowMethod();
        $("input[placeholder='Поиск по названию']").setValue(testData).pressEnter();
        sleep(2000);
        assertTrue($("#container").shouldHave(text(expectedText)).isDisplayed());
    }
    //todo, что случилось:
    // Фактический результат:
    // На странице "Каталог оправ"
    // не работает поиск по брендам Enni Marco и Enni Marco Emilia
    // если наименование товара содержит > 1 слова

    void alertWindowMethod() {
        if ($x("//h3[contains(.,'ПОЛИТИКА БЕЗОПАСНОСТИ')]").is(exist)) {
            $(".el-button--danger").shouldHave(text("Принять")).click();
        }
    }
}


