package Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BaseModel {

    @FindBy (xpath = "//div//a[text()='Sign in']")
    private WebElement signInButton;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage login() {
        getWait().until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();

        return new LoginPage(getDriver());
    }
}
