package test;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class UserData {
    private Faker faker = new Faker(new Locale("en-US"));

    private Date birthDate = faker.date().birthday(0, 120);

    private final String[] subjectList = {"Accounting", "Arts", "Biology", "Chemistry", "Civics", "Commerce",
            "Computer Science", "Economics", "English", "Hindi", "History", "Maths", "Physics", "Social Studies"},
            hobbiesList = {"Sports", "Reading", "Music"},
            stateList = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"},
            ncrCities = {"Delhi", "Gurgaon", "Noida"},
            uttarCities = {"Agra", "Lucknow", "Merrut"},
            haryanaCities = {"Karnal", "Panipat"},
            rajasthanCities = {"Jaipur", "Jaiselmer"},
            genderList = {"Male", "Female", "Other"};

    private final int subjectsQuantity = faker.number().numberBetween(1, 14),
            hobbiesQuantity = faker.number().numberBetween(1, 3);

    public Set<String> selectedSubjects = prepareUniqueSetFromArray(subjectList, subjectsQuantity),
            selectedHobbies = prepareUniqueSetFromArray(hobbiesList, hobbiesQuantity);

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.options().option(genderList),
            mobile = faker.phoneNumber().subscriberNumber(10),
            birthYear = dateFormat("yyyy", birthDate),
            birthMonth = dateFormat("MMMM", birthDate),
            birthDay = dateFormat("dd", birthDate),
            picture1 = "msk.jpg",
            address1 = faker.address().fullAddress(),
            state = faker.options().option(stateList),
            city = getCity(state);

    private String dateFormat(String pattern, Date date) {
        SimpleDateFormat simpleDate = new SimpleDateFormat(pattern, Locale.ENGLISH);
        return simpleDate.format(date);
    }

    private Set<String> prepareUniqueSetFromArray(String[] array, int quantity) {
        Set<String> result = new HashSet<>();
        for (int i = 1; i <= quantity; i++) {
            String randomSelection = faker.options().option(array);
            if (result.contains(randomSelection)) {
                i--;
            } else {
                result.add(randomSelection);
            }
        }
        return result;
    }

    private String getCity(String ofState) {
        return switch (ofState) {
            case "NCR" -> faker.options().option(ncrCities);
            case "Uttar Pradesh" -> faker.options().option(uttarCities);
            case "Haryana" -> faker.options().option(haryanaCities);
            case "Rajasthan" -> faker.options().option(rajasthanCities);
            default -> "";
        };
    }
}