package com.itigris.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ScippedTestExample extends TestBase{

    @Test
    @Disabled("Этот тест не будет запущен")
    @DisplayName("Пример пропущенного теста")
    public void skippedTest() {
        System.out.println("Тест пропущен");
    }
}
