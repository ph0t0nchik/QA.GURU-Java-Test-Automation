package lessons.les4_selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {
    @BeforeAll
    static void configureBrowser(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void andreiSolntsevShouldBeTheFirstContributor(){
        //открыть страницу репозитория селенида
        //подвести мышку к первому автору из блока contributors
        //проверка: во всплывающем окне есть текст Andrei Solntsev
        open("https://github.com/selenide/selenide");
        $("div.Layout-sidebar").$(byText("Contributors"))
                .closest(".BorderGrid-cell").$$("ul li").first().hover();
//              .closest("h2").sibling(0).$$("li").first().hover();
//        $$(".Popover").findBy(visible).shouldHave(text("Andrei Solntsev"));
        $(".Popover-message").shouldHave(text("Andrei Solntsev"));
    }
}
