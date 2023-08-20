package com.itigris.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ContactPage {

    // locators
    private SelenideElement nameInput = $("input[placeholder='Enter your full name']");
    private SelenideElement emailInput = $("input[placeholder='Enter your email address']");
    private SelenideElement telInput = $("input[placeholder='Enter your phone number']");
    private SelenideElement positionInput = $("input[placeholder='Enter your industry']");
    private SelenideElement aboutText = $("input[placeholder='Tell us about your Operations, Processes, etc.']");
    private SelenideElement buttonCheck = $$("span.el-checkbox__inner").last();
    private SelenideElement buttonSend = $("span[text()='SEND MESSAGE']");

    // actions
    public void setNameInput(String username) {

        nameInput.setValue(username);
    }

    public void setEmailInput(String email1) {

        emailInput.setValue(email1);
    }

    public void setTelInput(String tel1) {

        telInput.setValue(tel1);
    }

    public void setPositionInput(String position1) {

        positionInput.setValue(position1);
    }

    public void setAboutText(String aboutText1) {

        positionInput.setValue(aboutText1);
    }

    public void checkAcceptPrivacyPolicy() {

        buttonCheck.click();
    }

    public void pressSendKey() {

        buttonSend.click();
    }
}
