package lessons.les4_selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ExampleSelenideRepositorySearch {
    @BeforeAll
    static void configureBrowser(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void shouldFindSelenideRepositoryAtTheTop(){
        //открыть главную страницу
        //ввести в поле поиска selenide и нажать enter
        //кликнуть на первый репозиторий из списка найденных
        //проверка: заголовок selenide/selenide

        open("https://github.com/");
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $x("//a[@href='/selenide/selenide']").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }
}
