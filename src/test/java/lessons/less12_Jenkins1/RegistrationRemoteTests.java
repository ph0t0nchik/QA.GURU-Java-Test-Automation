package lessons.less12_Jenkins1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationRemoteTests {
    @BeforeAll
    static void configureBrowser(){
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    @Tag("remote")
    void successTest(){
        String userName = "Alex";

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Maximov");
        $("#userEmail").setValue("maximov@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1111111111");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(2);
        $("#dateOfBirth-wrapper").$(".react-datepicker__year-select").selectOptionByValue("2020");
        $("#dateOfBirth-wrapper").$(".react-datepicker__day--027:not(.react-datepicker__day--outside-month)").click();

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
        $(".table-responsive").shouldHave(text(userName), text("maximov@mail.ru"),
                text("NCR"), text("Maths"));

    }
}
