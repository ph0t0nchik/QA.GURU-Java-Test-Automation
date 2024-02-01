package lessons.les7_pageObjects;

import com.codeborne.selenide.SelenideElement;
import lessons.pages.RegistrationPageLes7;
import lessons.pages.components.CalendarComponentLes7;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBase {
    //расширили класс RegistrationWithPageObjectsTests, этот класс наследуется от TestBase. Сначала выполнится код в
    //а потом в RegistrationWithPageObjectsTests
    RegistrationPageLes7 registrationPage = new RegistrationPageLes7();
    @Test
    void successTest(){

        registrationPage
                .openPage()
                .setFirstName("Alex")
                .setLastName("Maximov")
                .setUserEmail("maximov@mail.ru")
                .setUGender("Male")
                .setUserNumber("1111111111")
                .setBirthDay("30", 2, "2020")
                .setSubjects("Maths")
                .setHobbies("Sports")
                .uploadPicture(Path.of("img/les3.jpg"))
                .setAddress("Moscow")
                .setStateAndCity("NCR","Delhi")
                .clickSubmit()

                //проверка значений
                .checkHeaderTable("Thanks for submitting the form")
                .checkResultTable("Student Name", "Alex Maximov")
                .checkResultTable("Student Email", "maximov@mail.ru")
                .checkResultTable("Gender", "Male")
                .checkResultTable("Mobile", "1111111111")
                .checkResultTable("Date of Birth", "30 March,2020")
                .checkResultTable("Subjects", "Maths")
                .checkResultTable("Hobbies", "Sports")
                .checkResultTable("Picture", "les3.jpg")
                .checkResultTable("Address", "Moscow")
                .checkResultTable("State and City", "NCR Delhi");
    }
}
