package com.itigris.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EssilorPage {
    // locators
    private SelenideElement textOurSuccessStories = $(byText("Our Success Stories"));
    private SelenideElement link = $("[href='/cases?project=essilor']");
    private ElementsCollection textIsTrue = $$("body");

    // actions
    public void checkTextOurSuccessStories() {
        textOurSuccessStories.isDisplayed();
    }

    public void checkLinkEssilor() {
        link.click();
    }

    public void checkEssilorIsTrue(String data) {
        textIsTrue.find(text(data)).shouldBe(visible);
    }
}
