package Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BaseModel{

    @FindBy (xpath = "//div[@class='panel-body']")
    private WebElement noticeSigned;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void checkingForSuccessfulLogin () {
        Assert.assertTrue(noticeSigned.isDisplayed());
        Assert.assertEquals(noticeSigned.getText(), "Signed in successfully.");
    }
}
