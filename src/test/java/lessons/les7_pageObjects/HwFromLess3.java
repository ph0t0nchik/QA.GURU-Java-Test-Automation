package lessons.les7_pageObjects;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class HwFromLess3 extends TestBase {
    //расширили класс HwFromLess3
    @Test
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
        // <div class="react-datepicker__day--027 react-datepicker__day--outside-month">27</div>
        // <div class="react-datepicker__day--027">27</div>
        $("#dateOfBirth-wrapper").$(".react-datepicker__day--027:not(.react-datepicker__day--outside-month)").click();
//        $x("//*[@class='react-datepicker__day--027'][not(contains(@class, 'react-datepicker__day--outside-month'))]").click();

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
