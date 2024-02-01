package lessons.les11_AllureReports;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lessons.les7_pageObjects.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class ExampleTest extends TestBase {
    @Test
    public void searchIssueTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        // добавили в отчет аллюра шаги теста

        open("https://github.com");
        $(".search-input").click();
        $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
        $("#query-builder-test").pressEnter();

        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("#880")).should(Condition.exist);
    }

}
