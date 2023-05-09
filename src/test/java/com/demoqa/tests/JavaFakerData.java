package com.demoqa.tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class JavaFakerData {
    Faker faker = new Faker();
    String[] genders = {"Male", "Female", "Other"};
    String[] subjects = {"Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"};
    String[] hobbies = {"Sports", "Reading", "Music"};

    String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

    public static final Map<String, String[]> cities = new HashMap<>();

    static {
        cities.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        cities.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        cities.put("Haryana", new String[]{"Karnal", "Panipat"});
        cities.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    }

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getGender() {
        return faker.options().option(genders);
    }

    public String getMobileNumber() {
        return faker.number().digits(10);
    }

    public String[] getBirthDate() {
        return new SimpleDateFormat("dd/MMMM/yyyy", Locale.ENGLISH).format(faker.date().birthday(17, 100)).split("/");
    }

    public String getSubject() {
        return faker.options().option(subjects);
    }

    public String getHobby() {
        return faker.options().option(hobbies);
    }

    public String getAddress() {
        return faker.address().streetAddress();
    }

    public String getState() {
        return faker.options().option(states);
    }

    public String getCity(String state) {
        return faker.options().option(cities.get(state));
    }
}