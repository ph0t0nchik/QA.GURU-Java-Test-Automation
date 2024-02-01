package lessons.les11_AllureReports;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import lessons.les7_pageObjects.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class WebSteps extends TestBase {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }
    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo){
        $(".search-input").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").pressEnter();
    }
    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo){
        $(linkText(repo)).click();
    }
    @Step("Открываем таб Issue")
    public void openIssueTab(){
        $("#issues-tab").click();
    }
    @Step("Проверяем наличие Issue с номером {issue}")
    public void shouldSeeIssueWithNumber(int issue){
        $(withText("#" + issue)).should(Condition.exist);
    }
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        //метод делать скриншот для гугла, просто найти в инете можно
    }
}
