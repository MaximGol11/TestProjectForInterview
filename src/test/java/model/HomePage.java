package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseModel{

    @FindBy (xpath = "//div[@class='panel-body']")
    private WebElement noticeSigned;

    @FindBy (id = "user-dropdown")
    private WebElement dropDownMenu;

    @FindBy (xpath = "//div//a[@class='logout']")
    private WebElement logout;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage selectLogout () {
        dropDownMenu.click();
        getWait().until(ExpectedConditions.visibilityOfAllElements(dropDownMenu));
        logout.click();

        return new LoginPage(getDriver());
    }
}
