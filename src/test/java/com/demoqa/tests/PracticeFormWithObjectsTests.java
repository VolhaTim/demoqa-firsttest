package com.demoqa.tests;

import com.demoqa.pages.PracticeFormObjects;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormWithObjectsTests extends TestBase{

    @Test
    void successPracticeFormTest(){

        practiceFormObjects.openPage()
                           .removeFooter()
                           .setFirstName("Alex")
                           .setLastName("Johnson")
                           .setUserEmail("aa@aaa.com")
                           .setGender("Male")
                           .setUserNumber("1234567890")
                           .setBirthDate("04","April","1990")
                           .setSubjectsInput("Chemistry")
                           .setHobbies("Reading")
                           .uploadPicture("src/test/resources/images/.png")
                           .setAddress("street 1")
                           .setState("NCR")
                           .setCity("Delhi")
                           .clickSubmit();

        practiceFormObjects.verifyRegistrationModalAppear()
                .verifyResult ("Student Name", "Alex Johnson")
                .verifyResult ("Student Email","aa@aaa.com")
                .verifyResult ("Gender","Male")
                .verifyResult ("Mobile","1234567890")
                .verifyResult ("Date of Birth","04 April,1990")
                .verifyResult ("Subjects","Chemistry")
                .verifyResult("Hobbies","Reading")
                .verifyResult("Picture",".png")
                .verifyResult("Address","street 1")
                .verifyResult("State and City","NCR Delhi");
    }
}


