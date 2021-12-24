package Model;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseModel {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class='panel-body']")
    private WebElement alertMessage;

    @FindBy (xpath = "//div//input[@placeholder='Weather in your city']")
    private WebElement headerSearch;

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(driver, 10);
        }
        return wait;
    }

    protected BaseModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }

    public String getAlertMessage() {
       return alertMessage.getText();
    }

    protected WebElement getHeaderSearch() {
        return headerSearch;
    }
}
