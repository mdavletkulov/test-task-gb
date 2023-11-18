package org.gb.task.ui.pages;

import org.gb.task.model.*;
import static org.gb.task.ui.PageHelpers.*;
import org.gb.task.ui.pages.main.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage extends BaseUiComponent {
    private static final String PAGE_PATH = "/login";

    private static final String formCss = "form#login";

    @FindBy(css = formCss + " input[type='text']")
    private WebElement userNameInput;

    @FindBy(css = formCss + " input[type='password']")
    private WebElement passwordInput;

    @FindBy(css = formCss + " button")
    private WebElement confirmButton;

    public LoginPage(WebDriver browser) {
        super(browser);
        PageFactory.initElements(browser, this);
    }

    public static LoginPage openLoginPage(WebDriver browser) {
        openPage(browser, PAGE_PATH);
        return new LoginPage(browser);
    }

    public MainPage login(User user) {
        userNameInput.sendKeys(user.getLogin());
        passwordInput.sendKeys(user.getPassword());
        confirmButton.click();
        return new MainPage(browser);
    }

    public LoginPage checkPageAppear() {
        wait.until(d -> userNameInput.isDisplayed());
        wait.until(d -> passwordInput.isDisplayed());
        wait.until(d -> confirmButton.isDisplayed());
        return this;
    }
}
