package com.itigris.tests;

import com.itigris.pages.TeamPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class TeamTests extends TestBase {

    TeamPage teamPage = new TeamPage();

    String url = "/team";

    @Test
    @Tag("siteTests")
    @DisplayName("Проверка текстов на странице Team")
    void searshTextElement() {
        open(url);
        teamPage.checkTextHeader();
        teamPage.checkMeetOurTeamVisible();
        teamPage.checkMichaelKhurginVisible();
        teamPage.checkEmailVisible();
        teamPage.checkTextFooter(); //bug
    }
    //TODO
    /*
    Фактический результат: В футере itigris.com стоит 2020 год.
    Ожидаемый результат: 2023
     */
}