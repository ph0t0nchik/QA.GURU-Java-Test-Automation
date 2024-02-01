package lessons.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponentLes7 {
    public void setDate(String day, int month, String year){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)").click();
    }


}
