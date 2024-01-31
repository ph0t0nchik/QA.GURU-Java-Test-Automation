package lessons.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPageLes7 {
//    String loginInputLocator = "#firstName" BAD Practice
    SelenideElement
        firstNameInput = $("#firstName"),
        lastNameInput = $("#lastName"),
        userEmailInput = $("#userEmail"),
        genderWrapper = $("#genterWrapper");

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
}
