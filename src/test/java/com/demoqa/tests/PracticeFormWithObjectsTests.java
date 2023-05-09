package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class PracticeFormWithObjectsTests extends TestBase{

    @Test
    void successPracticeFormTest(){
        JavaFakerData javaFakerData = new JavaFakerData();

        String firstName = javaFakerData.getFirstName(),
               lastName = javaFakerData.getLastName(),
               userEmail = javaFakerData.getEmail(),
               gender = javaFakerData.getGender(),
               userNumber = javaFakerData.getMobileNumber(),
               subjects = javaFakerData.getSubject(),
               hobbies = javaFakerData.getHobby(),
               address = javaFakerData.getAddress(),
               state = javaFakerData.getState(),
               city = javaFakerData.getCity(state);
        String[] birthday = javaFakerData.getBirthDate();

        practiceFormObjects.openPage()
                           .removeFooter()
                           .setFirstName(firstName)
                           .setLastName(lastName)
                           .setUserEmail(userEmail)
                           .setGender(gender)
                           .setUserNumber(userNumber)
                           .setBirthDate(birthday)
                           .setSubjectsInput(subjects)
                           .setHobbies(hobbies)
                           .uploadPicture("src/test/resources/images/.png")
                           .setAddress(address)
                           .setState(state)
                           .setCity(city)
                           .clickSubmit();

        practiceFormObjects.verifyRegistrationModalAppear()
                .verifyResult ("Student Name", firstName + " " + lastName)
                .verifyResult ("Student Email",userEmail)
                .verifyResult ("Gender",gender)
                .verifyResult ("Mobile",userNumber)
                .verifyResult ("Date of Birth","04 April,1990")
                .verifyResult ("Subjects",subjects)
                .verifyResult("Hobbies",hobbies)
                .verifyResult("Picture",".png")
                .verifyResult("Address",address)
                .verifyResult("State and City",state + " " + city);
    }
}


