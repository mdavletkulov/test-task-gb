package org.gb.task.ui;

import java.time.*;
import org.gb.task.configuration.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class PageHelpers {

    public static final Duration WAIT_TIME = Duration.ofSeconds(15);
    public static final Duration POLL_INTERVAL = Duration.ofMillis(500);

    public static void openPage(WebDriver browser, String pagePath) {
        browser.get(MainConfig.getBaseUrl() + pagePath);
    }

    public static FluentWait<WebElement> defaultElementWaiter(WebElement element) {
        return new FluentWait<>(element)
                .withTimeout(WAIT_TIME)
                .pollingEvery(POLL_INTERVAL)
                .ignoring(NoSuchElementException.class);
    }

}
