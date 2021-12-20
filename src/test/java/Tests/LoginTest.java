package Tests;

import Base.BaseTest;
import Model.HomePage;
import Model.MainPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private final static String LOGIN = "maxim.golubtsov@yahoo.com";
    private final static String PASSWORD = "exampLe1";

    @Test
    public void testLogin() {
        HomePage homePage = new MainPage(getDriver())
                .login()
                .fillEmail(LOGIN)
                .fillPassword(PASSWORD)
                .clickSubmitButton();

        homePage.checkingForSuccessfulLogin();
    }
}
