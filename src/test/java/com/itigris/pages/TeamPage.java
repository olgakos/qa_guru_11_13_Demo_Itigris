package com.itigris.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TeamPage {

    // locators
    private SelenideElement textHeader = $("#header-nav");
    private SelenideElement textMeetOurTeamVisible = $(byText("Meet Our Team"));
    private SelenideElement textMichaelKhurginVisible = $(".my-6");
    private SelenideElement textEmail = $(By.linkText("info@itigris.com"));
    private ElementsCollection textFooter = $$("#the-footer");

    // actions
    public void checkTextHeader() {
        textHeader.shouldHave(text("ITIGRIS"));
    }

    public void checkMeetOurTeamVisible() {
        textMeetOurTeamVisible.shouldBe(visible);
    }

    public void checkMichaelKhurginVisible() {
        textMichaelKhurginVisible.shouldHave(text("Michael Khurgin"));
    }

    public void checkEmailVisible() {
        textEmail.isDisplayed();
    }

    public void checkTextFooter() {
        textFooter.find(text("© 2020 ITigris Ltd.")).shouldBe(visible);
    }

}
