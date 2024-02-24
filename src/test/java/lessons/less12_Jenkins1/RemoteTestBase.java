package lessons.less12_Jenkins1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;
import java.util.Objects;

import static com.codeborne.selenide.impl.Cleanup.of;
import static java.util.List.of;

public class RemoteTestBase {
    @BeforeAll
    static void configureBrowser(){
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";

        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        //прописываем ряд опций для селеноида
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
}
