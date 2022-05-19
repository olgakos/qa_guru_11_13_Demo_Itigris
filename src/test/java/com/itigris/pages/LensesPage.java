package com.itigris.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LensesPage {

    // locators
    private SelenideElement textHeader = $("body");

    // actions
    public void checkTextHeader() {
        textHeader.shouldHave(text("Каталог очковых линз"));
    }
}