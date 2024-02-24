package lessons.less12_Jenkins1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class RegistrationRemoteTests extends RemoteTestBase{

    @Test
    @Tag("remote")
    @DisplayName("Successful registration")
    void successTest(){
        step("Open form", () ->{
            open("/automation-practice-form");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
            $x("//button//p").click(); //закрыть окно, которое мешает началу теста
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        });
        step("Fill form",() -> {
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
        });
        step("Verify results", () -> {
            $(".modal-dialog").shouldBe(appear);
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(text("Alex"), text("maximov@mail.ru"),
                    text("NCR"), text("Maths"));
        });
    }
}
