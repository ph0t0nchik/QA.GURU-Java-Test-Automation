package lessons.les7_pageObjects;

import com.codeborne.selenide.SelenideElement;
import lessons.pages.RegistrationPageLes7;
import lessons.pages.components.CalendarComponentLes7;
import org.junit.jupiter.api.Test;

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

        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Maximov")
                .setUserEmail("maximov@mail.ru")
                .setUGender("Other")
                .setUserNumber("1111111111")
                .setBirthDay("30", "2", "2020");


        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();

        $("#uploadPicture").uploadFromClasspath("img/les3.jpg");

        $("#currentAddress").setValue("Moscow");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();

        $(".modal-dialog").shouldBe(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex"), text("maximov@mail.ru"),
                text("NCR"), text("Maths"));

    }
}
