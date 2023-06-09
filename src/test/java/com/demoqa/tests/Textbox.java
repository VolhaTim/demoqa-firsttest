package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Textbox {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successTextBoxTest() {
        open("/text-box");

        $("[id=userName]").setValue("Smith");
        $("[id=userEmail]").setValue("aa@aaa.com");
        $("[id=currentAddress]").setValue("test 1");
        $("[id=permanentAddress]").setValue("test 2");
        $("[id=submit]").click();

        $("[id=output]").shouldHave(text("Smith"), text("aa@aaa.com"), text("test 1"), text("test 2"));
    }
}
