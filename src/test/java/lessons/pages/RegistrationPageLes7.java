package lessons.pages;

import com.codeborne.selenide.SelenideElement;
import lessons.pages.components.CalendarComponentLes7;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPageLes7 {
//    String loginInputLocator = "#firstName" BAD Practice
    CalendarComponentLes7 calendarComponent = new CalendarComponentLes7();
    SelenideElement
        firstNameInput = $("#firstName"),
        lastNameInput = $("#lastName"),
        userEmailInput = $("#userEmail"),
        genderWrapper = $("#genterWrapper"),
        userNumberINput = $("#userNumber"),
        birthDayInput = $("#dateOfBirthInput");

    public RegistrationPageLes7 openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }
    public RegistrationPageLes7 setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPageLes7 setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPageLes7 setUserEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPageLes7 setUGender (String value){
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPageLes7 setUserNumber (String value){
        userNumberINput.setValue(value);
        return this;
    }

    public RegistrationPageLes7 setBirthDay (String day, String month, String year){
        birthDayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
}
