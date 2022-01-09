package model;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends BaseModel {

    @FindBy (xpath = "//div//a[text()='Sign in']")
    private WebElement signInButton;

    @FindBy (xpath = "//div[@class='owm-loader-container']")
    private WebElement loader;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage login() {
        getWait().until(ExpectedConditions.invisibilityOf(loader));
        signInButton.click();

        return new LoginPage(getDriver());
    }

    public SearchPage searchCity(String cityName) {
        getHeaderSearch().sendKeys(cityName + "\n");
        return new SearchPage(getDriver());
    }

}
