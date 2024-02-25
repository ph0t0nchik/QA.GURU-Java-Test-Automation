package lessons.less17_ownerLib;

import lessons.less17_ownerLib.config.WebDriverProvider;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest {
    private WebDriver driver;
    @BeforeEach
    public void startDriver(){
        //подготовка драйвера
        driver = new WebDriverProvider().get();
    }

    @Test
    @Tag("owner")
    @Disabled
     public void testGithub() {
        //тело выполнения теста
        String title = driver.getTitle();
        assertEquals("GitHub: Let’s build from here · GitHub", title);
        driver.quit();
    }

    @AfterEach
    public void stopDriver(){
        driver.quit();
    }
}
