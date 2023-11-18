package org.gb.task.ui.pages.main;

import org.gb.task.ui.pages.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class CreateForm extends BaseUiComponent {

    @FindBy(xpath = ".//span[text()='Creating Dummy']/ancestor::div[@class='mdc-dialog__container']")
    private WebElement formRoot;

    private final By buttonBy = By.cssSelector("button[type='submit']");
    private final By closeButton = By.cssSelector("button[data-mdc-dialog-action='close']");

    public CreateForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CreateForm checkFormAppear() {
        wait.until(d -> formRoot.isDisplayed());
        return this;
    }

    public CreateForm clickSaveButton() {
        formRoot.findElement(buttonBy).click();
        return this;
    }

    public void clickCloseButton() {
        formRoot.findElement(closeButton).click();
    }

    public CreateForm fillFirstName(String value) {
        fillField("Fist Name", value);
        return this;
    }

    public CreateForm fillLastName(String value) {
        fillField("Last Name", value);
        return this;
    }

    public CreateForm fillLogin(String value) {
        fillField("Login", value);
        return this;
    }

    private void fillField(String fieldName, String value) {
        var input = formRoot.findElement(By
                .xpath(".//span[text()='%s']/following-sibling::input".formatted(fieldName)));
        wait.until(d -> input.isDisplayed());
        input.sendKeys(value);
    }


}
