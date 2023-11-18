package org.gb.task.utils;

import java.net.*;
import java.util.*;
import static org.gb.task.configuration.MainConfig.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.*;

public class BrowserManager {

    public static WebDriver createDriverSession() {
        ChromeOptions options = new ChromeOptions();

        options.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "manual", "true"
        ));
        options.setAcceptInsecureCerts(true);
        WebDriver driver;
        try {
            var url = URI.create(getSelenoidHubUrl()).toURL();
            driver = new RemoteWebDriver(url, options);
        } catch (MalformedURLException exception) {
            throw new IllegalArgumentException("Smth wrong with url");
        }
        return driver;
    }

    public static boolean isOpen(WebDriver driver) {
        try {
            driver.getWindowHandles();
            return true;
        } catch (NullPointerException | NoSuchSessionException e) {
            return false;
        }
    }
}
