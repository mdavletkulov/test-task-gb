package org.gb.task.ui.pages.main;

import java.util.*;
import org.gb.task.ui.pages.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class MainPage extends BaseUiComponent {

    @FindBy(xpath = ".//h1[text()='Student Page']")
    private WebElement headerName;

    @FindBy(className = "mdc-data-table")
    private WebElement table;

    @FindBy(id = "create-btn")
    private WebElement createButton;

    @FindBy(className = "mdc-data-table__row")
    private List<WebElement> rows;

    public MainPage(WebDriver browser) {
        super(browser);
        PageFactory.initElements(browser, this);
    }

    public CreateForm openCreateForm() {
        createButton.click();
        return new CreateForm(browser).checkFormAppear();
    }

    public MainPage checkPageAppear() {
        wait.until(d -> headerName.isDisplayed());
        wait.until(d -> table.isDisplayed());
        wait.until(d -> createButton.isDisplayed());
        return this;
    }

    public TableGroup getGroupByName(String name) {
        wait.until(d -> rows.stream()
                .map(TableGroup::new)
                .anyMatch(tableGroup -> tableGroup.getName().equals(name)));

        return rows.stream()
                .map(TableGroup::new)
                .filter(tableGroup -> tableGroup.getName().equals(name))
                .findFirst().orElseThrow(() ->
                        new RuntimeException("Row with name %s can not be found".formatted(name)));
    }


}
