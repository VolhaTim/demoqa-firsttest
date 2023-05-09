package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.PracticeFormObjects;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    PracticeFormObjects practiceFormObjects = new PracticeFormObjects();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1680x1050";
        Configuration.holdBrowserOpen = true;
    }
}
