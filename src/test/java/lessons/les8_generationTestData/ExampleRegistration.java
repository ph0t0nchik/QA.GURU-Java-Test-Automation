package lessons.les8_generationTestData;

import lessons.les7_pageObjects.TestBase;
import lessons.pages.RegistrationPageLes7;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

public class ExampleRegistration extends TestBase {
    //расширили класс RegistrationWithPageObjectsTests, этот класс наследуется от TestBase. Сначала выполнится код в
    //а потом в RegistrationWithPageObjectsTests
    RegistrationPageLes7 registrationPage = new RegistrationPageLes7();

    String
            firstName = "Alex",
            lastName = "Maximov",
            email = "maximov@mail.ru",
            gender = "Male",
            userNumber = "1111111111";
    @Test
    void successTest(){

        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setUGender(gender)
                .setUserNumber(userNumber)
                .setBirthDay("30", 2, "2020")
                .setSubjects("Maths")
                .setHobbies("Sports")
                .uploadPicture(Path.of("img/les3.jpg"))
                .setAddress("Moscow")
                .setStateAndCity("NCR","Delhi")
                .clickSubmit()

                //проверка значений
                .checkHeaderTable("Thanks for submitting the form")
                .checkResultTable("Student Name", firstName + lastName)
                .checkResultTable("Student Email", email)
                .checkResultTable("Gender", gender)
                .checkResultTable("Mobile", userNumber)
                .checkResultTable("Date of Birth", "30 March,2020")
                .checkResultTable("Subjects", "Maths")
                .checkResultTable("Hobbies", "Sports")
                .checkResultTable("Picture", "les3.jpg")
                .checkResultTable("Address", "Moscow")
                .checkResultTable("State and City", "NCR Delhi");
    }
}
