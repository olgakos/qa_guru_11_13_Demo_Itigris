package com.itigris.tests;

import com.itigris.pages.EssilorPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class EssilorTests extends TestBase {
    EssilorPage essilorPage = new EssilorPage();

    String url = "/cases";
    String data = "Essilor";
    //String data = "Alcon"; //negative test

    @Test
    @Tag("siteTests")
    @DisplayName("Проверка названия в карточке кейса Essilor")
    void searchCasesTest() {
        open(url);
        essilorPage.checkTextOurSuccessStories();
        essilorPage.checkLinkEssilor();
        essilorPage.checkEssilorIsTrue(data);
    }
}
