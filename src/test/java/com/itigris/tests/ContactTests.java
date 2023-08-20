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
    String setPhone = "+7921781хххх";
    String setPosition = "QA engineer";
    String setText = "Text text";

    @Test
    @Tag("siteTests")
    @DisplayName("Заполнение формы обратной связи")
    void fillFormTest() {
        open(url);
        contactPage.setNameInput(setName);
        contactPage.setEmailInput(setEmail);
        contactPage.setTelInput(setPhone);
        contactPage.setPositionInput(setPosition);
        contactPage.setAboutText(setText);
        contactPage.checkAcceptPrivacyPolicy();
//      contactPage.pressSendKey(); //пропускаю шаг "отправить"
    }
}
