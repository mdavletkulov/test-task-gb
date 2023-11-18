package org.gb.task.ui.pages;

import static org.gb.task.ui.PageHelpers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public abstract class BaseUiComponent {

    protected final WebDriver browser;
    protected final WebDriverWait wait;

    protected BaseUiComponent(WebDriver browser) {
        this.browser = browser;
        this.wait = new WebDriverWait(browser, WAIT_TIME);
    }
}
