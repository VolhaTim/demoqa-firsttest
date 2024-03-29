package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class PracticeForm extends TestBase{
    @Test
    @Tag("remote")
    @DisplayName("Successful registration1")
    void successPracticeFormTest(){

        step ("Open form", () -> {
                    open("/automation-practice-form");
                    executeJavaScript("$('#fixedban').remove()");
                    executeJavaScript("$('footer').remove()");
        });

        step ("Fill form", () -> {
         $("#firstName").setValue("Tom");
         $("#lastName").setValue("Johnson");
         $("#userEmail").setValue("aa@aaa.com");
         $("#genterWrapper").$(byText("Male")).click();
         $("#userNumber").setValue("1234567890");
         $("#dateOfBirthInput").click();
         $(".react-datepicker__month-select").selectOption("April");
         $(".react-datepicker__year-select").selectOption("1990");
         $(".react-datepicker__day--004:not(.react-datepicker__day--outside-month)").click();
         $("#subjectsInput").setValue("Chemistry").pressEnter();
         $("#hobbiesWrapper").$(byText("Reading")).click();
         $("#uploadPicture").uploadFile(new File("src/test/resources/images/.png"));
         $("#currentAddress").setValue("street 1");
         $("#state").click();
         $("#stateCity-wrapper").$(byText("NCR")).click();
         $("#city").click();
         $("#stateCity-wrapper").$(byText("Delhi")).click();
         $("#submit").click();
        });

        step ("Verify form", () -> {
          $(".modal-dialog").should(appear);
          $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
          $(".table-responsive").shouldHave(text("Tom"), text("aa@aaa.com"), text("1234567890"));
        });
    }
}
