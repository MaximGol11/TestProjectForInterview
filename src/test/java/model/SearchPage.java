package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BaseModel{

    @FindBy (xpath = "//tr//b//a")
    private List<WebElement> searchResults;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public CityPage openCityPage() {
        searchResults.get(0).click();

        return new CityPage(getDriver());
    }
}
