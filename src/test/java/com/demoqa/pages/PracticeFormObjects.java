package com.demoqa.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static java.lang.String.format;


public class PracticeFormObjects {
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModal resultsModal = new ResultsModal();
    //Selenide Elements

    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput =$("#lastName");

    SelenideElement userEmailInput =$("#userEmail");

    SelenideElement gender =$("#genterWrapper");
    SelenideElement userNumberInput =$("#userNumber");
    SelenideElement subjectsInput =$("#subjectsInput");
    SelenideElement hobbies =$("#hobbiesWrapper");
    SelenideElement picture =$("#uploadPicture");
    SelenideElement addressInput =$("#currentAddress");
    SelenideElement state =$("#state");
    SelenideElement city =$("#city");

    SelenideElement stateAndCityWrapper =$("#stateCity-wrapper");
    SelenideElement submit =$("#submit");



    //Actions
    public PracticeFormObjects OpenPage () {
        open("/automation-practice-form");
        return this;
    }
    public PracticeFormObjects RemoveFooter () {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
   public PracticeFormObjects SetFirstName (String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormObjects SetLastName (String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public PracticeFormObjects SetUserEmail (String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public PracticeFormObjects SetGender (String value) {
        gender.$(byText(value)).click();
        return this;
    }
    public PracticeFormObjects SetUserNumber (String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public PracticeFormObjects SetBirthDate(String day, String month, String year) {
        calendarComponent.SetDate(day, month, year);
        return this;
    }
    public PracticeFormObjects SetSubjectsInput (String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public PracticeFormObjects SetHobbies (String value) {
        hobbies.$(byText(value)).click();
        return this;
    }
    public PracticeFormObjects UploadPicture (String value) {
        picture.uploadFile(new File(value));
        return this;
    }
    public PracticeFormObjects SetAddress (String value) {
        addressInput.setValue(value);
        return this;
    }
    public PracticeFormObjects SetState (String value) {
        state.click();
        stateAndCityWrapper.$(byText(value)).click();
        return this;
    }
        public PracticeFormObjects SetCity (String value) {
            city.click();
            stateAndCityWrapper.$(byText(value)).click();
            return this;
    }
    public void ClickSubmit () {
        submit.click();
    }

    public PracticeFormObjects VerifyRegistrationModalAppear () {
       resultsModal.VerifyModalAppear();
    return this;
    }
    public PracticeFormObjects VerifyResult (String key, String value) {
     resultsModal.VerifyResult(key, value);
      return this;
    }
}