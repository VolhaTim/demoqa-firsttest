package com.demoqa.pages.components;

import com.demoqa.pages.PracticeFormObjects;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsModal {
    public void VerifyModalAppear() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
    public void VerifyResult (String key,String value) {
    $(".table-responsive").$(byText(key)).sibling(0).shouldHave(text(value));

    }
}