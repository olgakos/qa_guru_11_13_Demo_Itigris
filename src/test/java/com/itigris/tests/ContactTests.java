package com.itigris.tests;

import com.itigris.pages.ContactPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class ContactTests extends TestBase {
    ContactPage contactPage = new ContactPage();

    String url = "/contact-us";
    String setName = "Olga Kos";
    String setEmail = "test@test.test";
    String setTel = "+7921781хххх";
    String setPosition = "QA engineer";

    @Test
    @Tag("siteTests")
    @DisplayName("Заполнение формы обратной связи")
    void fillFormTest() {
        open(url);
        contactPage.setNameInput(setName);
        contactPage.setEmailInput(setEmail);
        contactPage.setTelInput(setTel);
        contactPage.setPositionInput(setPosition);
        contactPage.checkAcceptPrivacyPolicy();
        //$x("//span[text()='SEND MESSAGE']").click(); //намеренно пропускаю шаг "отправить"
    }
}
