package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModalComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static java.lang.String.format;


public class PracticeFormObjects {
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModalComponent resultsModal = new ResultsModalComponent();
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
    public PracticeFormObjects openPage () {
        open("/automation-practice-form");
        return this;
    }
    public PracticeFormObjects removeFooter () {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
   public PracticeFormObjects setFirstName (String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormObjects setLastName (String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public PracticeFormObjects setUserEmail (String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public PracticeFormObjects setGender (String value) {
        gender.$(byText(value)).click();
        return this;
    }
    public PracticeFormObjects setUserNumber (String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public PracticeFormObjects setBirthDate(String[] birthdayDate) {
        calendarComponent.setDate(birthdayDate[0], birthdayDate[1], birthdayDate[2]);
        return this;
    }
    public PracticeFormObjects setSubjectsInput (String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public PracticeFormObjects setHobbies (String value) {
        hobbies.$(byText(value)).click();
        return this;
    }
    public PracticeFormObjects uploadPicture (String value) {
        picture.uploadFile(new File(value));
        return this;
    }
    public PracticeFormObjects setAddress (String value) {
        addressInput.setValue(value);
        return this;
    }
    public PracticeFormObjects setState (String value) {
        state.click();
        stateAndCityWrapper.$(byText(value)).click();
        return this;
    }
    public PracticeFormObjects setCity (String value) {
        city.click();
        stateAndCityWrapper.$(byText(value)).click();
        return this;
    }
    public void clickSubmit () {
        submit.click();
    }

    public PracticeFormObjects verifyRegistrationModalAppear () {
       resultsModal.verifyModalAppear();
    return this;
    }
    public PracticeFormObjects verifyResult (String key, String value) {
     resultsModal.verifyResult(key, value);
      return this;
    }
}