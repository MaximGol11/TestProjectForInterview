package Tests;

import Base.BaseTest;
import Model.HomePage;
import Model.LoginPage;
import Model.MainPage;
import org.testng.Assert;
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

        Assert.assertEquals(homePage.getAlertMessage(), "Signed in successfully.");
    }

    @Test (dependsOnMethods = "testLogin")
    public void testLogout() {
        LoginPage loginPage = new HomePage(getDriver())
                .selectLogout();

        Assert.assertEquals(loginPage.getAlertMessage(), "You need to sign in or sign up before continuing.");
    }
}
