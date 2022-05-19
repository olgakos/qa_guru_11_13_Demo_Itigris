package com.itigris.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GlassesFramesPage {

    // locators
    private SelenideElement textHeader = $("#frames-page");
    private SelenideElement goodsSearch = $("input[placeholder='Поиск по названию']");
    private SelenideElement goodsCheck1 = $(".el-card__body").$(byText("Fixiki F7111"));

    // actions
    public void checkTextHeader() {
        textHeader.shouldHave(text("Каталог оправ"));
    }

    public void setGoodsInput(String goods) {
        goodsSearch.setValue(goods).pressEnter();
    }

    public void checkGoodsSearch() {
        goodsCheck1.should(appear, Duration.ofSeconds(10));


    }


}
