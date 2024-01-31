package lessons.les7_pageObjects;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void configureBrowser(){
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
//        executeJavaScript("$('#fixedban').remove()"); //скрыли рекламу
//        executeJavaScript("$('footer').remove()"); //удалили футер, чтобы не загораживать нужный элемент
    }
}
