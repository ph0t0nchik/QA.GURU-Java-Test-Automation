package lessons.les11_AllureReports;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lessons.les7_pageObjects.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AttachmentsTest extends TestBase {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 80;
    @Test
    public void testLambdaAttachments(){
//      Lambda - название подхода по созданию теста (функция с одним аргументом)
//      Считать, что Lambda некое сокращение кода, некоторый термин, цель которого убрать
//      визуальный мусор

        SelenideLogger.addListener("allure", new AllureSelenide());
        // добавили в отчет аллюра шаги теста
        step("Открываем главную страницу", () -> {
            open("https://github.com");
            attachment("Source", webdriver().driver().source());
        });

    }

    //аналог теста выше только более оптимально и удобно
    @Test
    public void testAnnotatedAttachments(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.takeScreenshot();
    }
}
