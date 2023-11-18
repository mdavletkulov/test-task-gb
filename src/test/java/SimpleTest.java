import java.util.*;
import org.gb.task.model.*;
import static org.gb.task.ui.pages.LoginPage.*;
import static org.gb.task.utils.UsersRegistry.*;
import org.junit.jupiter.api.*;


public class SimpleTest extends BaseUITest {

    private final User testUser = getSimpleUser();

    @Test
    @DisplayName("Simple task test")
    public void simpleTest() {
        var loginPage = openLoginPage(browser).checkPageAppear();

        var mainPage = loginPage.login(testUser).checkPageAppear();
        var createForm = mainPage.openCreateForm();
        var lastName = "New Group";
        var firstName = String.valueOf(System.currentTimeMillis());
        createForm.fillLogin(UUID.randomUUID().toString())
                .fillLastName(lastName)
                .fillFirstName(firstName)
                .clickSaveButton()
                .clickCloseButton();

        var groupRow = mainPage.getGroupByName("%s %s".formatted(lastName, firstName));
        groupRow.checkStatus(true);
        groupRow.clickDeleteButton();
        groupRow.checkStatus(false);
        groupRow.clickRestoreButton();
        groupRow.checkStatus(true);
    }

}
