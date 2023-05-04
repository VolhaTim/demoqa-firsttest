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

        practiceFormObjects.OpenPage()
                           .RemoveFooter()
                           .SetFirstName("Alex")
                           .SetLastName("Johnson")
                           .SetUserEmail("aa@aaa.com")
                           .SetGender("Male")
                           .SetUserNumber("1234567890")
                           .SetBirthDate("04","April","1990")
                           .SetSubjectsInput("Chemistry")
                           .SetHobbies("Reading")
                           .UploadPicture("src/test/resources/images/.png")
                           .SetAddress("street 1")
                           .SetState("NCR")
                           .SetCity("Delhi")
                           .ClickSubmit();

        practiceFormObjects.VerifyRegistrationModalAppear()
                .VerifyResult ("Student Name", "Alex")
                .VerifyResult ("Student Email","aa@aaa.com")
                .VerifyResult ("Mobile","1234567890");

    }
}


