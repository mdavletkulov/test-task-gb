import org.gb.task.configuration.*;
import static org.gb.task.utils.BrowserManager.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.*;
import org.openqa.selenium.*;

@TestInstance(PER_CLASS)
public class BaseUITest {

    protected WebDriver browser;

    @BeforeEach
    @DisplayName("Open main page")
    public void openMainPage() {
        if (!isOpen(browser)) browser = createDriverSession();
        browser.manage().deleteAllCookies();
        browser.get(MainConfig.getBaseUrl());
    }

    @AfterAll
    @DisplayName("Close browser")
    public void closeBrowser() {
        browser.quit();
    }

}
