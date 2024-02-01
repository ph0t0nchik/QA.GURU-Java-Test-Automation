package lessons.pages;

import com.codeborne.selenide.SelenideElement;
import lessons.pages.components.CalendarComponentLes7;
import lessons.pages.components.ResultTableLes7;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPageLes7 {
//    String loginInputLocator = "#firstName" BAD Practice
    CalendarComponentLes7 calendarComponent = new CalendarComponentLes7();
    ResultTableLes7 resultTable = new ResultTableLes7();
    SelenideElement
        firstNameInput = $("#firstName"),
        lastNameInput = $("#lastName"),
        userEmailInput = $("#userEmail"),
        genderWrapper = $("#genterWrapper"),
        userNumberINput = $("#userNumber"),
        birthDayInput = $("#dateOfBirthInput"),
        subjectsInput = $("#subjectsInput"),
        hobbiesInput = $("#hobbiesWrapper"),
        pictureUpload = $("#uploadPicture"),
        addressInput = $("#currentAddress"),
        stateInput =  $("#state"),
        cityInput =  $("#city"),
        selectList = $("#stateCity-wrapper"),
        pressSubmit = $("#submit"),
        openResultTable = $(".modal-dialog");


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
    public RegistrationPageLes7 setBirthDay (String day, int month, String year){
        birthDayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPageLes7 setSubjects (String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPageLes7 setHobbies (String value){
        hobbiesInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPageLes7 uploadPicture (Path paths){
        pictureUpload.uploadFromClasspath(String.valueOf(paths));
        return this;
    }
    public RegistrationPageLes7 setAddress (String value){
        addressInput.setValue("Moscow");
        return this;
    }
    public RegistrationPageLes7 setStateAndCity (String state, String city){
        stateInput.click();
        selectList.$(byText(state)).click();
        cityInput.click();
        selectList.$(byText(city)).click();
        return this;
    }
    public RegistrationPageLes7 clickSubmit (){
        pressSubmit.click();
        return this;
    }
    public RegistrationPageLes7 checkHeaderTable (String header){
        openResultTable.shouldBe(appear);
        resultTable.verifyHeaderInResultTable(header);
        return this;
    }
    public RegistrationPageLes7 checkResultTable (String key, String value){
        resultTable.verifyValueInResultTable(key, value);
        return this;
    }
}
