package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseModel {

    @FindBy (id = "user_email")
    private WebElement email;

    @FindBy (id = "user_password")
    private WebElement password;

    @FindBy (name = "commit")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillEmail(String value) {
        email.sendKeys(value);

        return this;
    }

    public LoginPage fillPassword(String value) {
        password.sendKeys(value);

        return this;
    }

    public HomePage clickSubmitButton() {
        submitButton.click();

        return new HomePage(getDriver());
    }

}
