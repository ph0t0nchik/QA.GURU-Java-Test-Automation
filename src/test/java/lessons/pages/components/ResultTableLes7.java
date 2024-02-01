package lessons.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableLes7 {
    SelenideElement
        table = $(".table-responsive"),
        header = $("#example-modal-sizes-title-lg");

    public void verifyHeaderInResultTable(String value){
        header.shouldHave(text(value));
    }
    public void verifyValueInResultTable(String key, String value){
        table.$(byText(key)).sibling(0).shouldHave(text(value));
    }
}
