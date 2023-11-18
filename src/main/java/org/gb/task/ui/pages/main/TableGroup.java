package org.gb.task.ui.pages.main;

import static org.gb.task.ui.PageHelpers.*;
import org.openqa.selenium.*;

public class TableGroup {

    private final WebElement root;

    public TableGroup(WebElement root) {
        this.root = root;
    }

    private static final int NAME_INDEX = 1;
    private static final int STATUS_INDEX = 3;

    public String getName() {
        return getCellByIndex(NAME_INDEX).getText();
    }

    public void clickDeleteButton() {
        root.findElement(By.xpath(".//button[text()='delete']")).click();
    }

    public void clickRestoreButton() {
        root.findElement(By.xpath(".//button[text()='restore_from_trash']")).click();
    }

    public void checkStatus(boolean active) {
        defaultElementWaiter(getCellByIndex(STATUS_INDEX))
                .until(element -> element.getText().equals(active ? "active" : "inactive"));
    }

    private WebElement getCellByIndex(int index) {
        var cells = root.findElements(By.className("mdc-data-table__cell"));
        return cells.get(index);
    }
}
