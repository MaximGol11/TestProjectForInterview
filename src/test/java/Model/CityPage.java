package Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CityPage extends BaseModel{

    @FindBy (xpath = "//div[contains(text(), 'Imperial')]")
    private WebElement imperialTempSwitch;

    @FindBy (xpath = "//div[@class='current-temp']")
    private WebElement currentTemp;

    @FindBy (xpath = "//div[@class='owm-loader-container']")
    private WebElement loader;

    public CityPage(WebDriver driver) {
        super(driver);
    }

    public void imperialTempSwitch () {
        getWait().until(ExpectedConditions.invisibilityOf(loader));
        imperialTempSwitch.click();
        getWait().until(ExpectedConditions.invisibilityOf(loader));
    }

    public int getCurrentTemp () {
     String celsiusTemp = currentTemp.getText().replaceAll("[^0-9, -]", "");
        return Integer.parseInt(celsiusTemp);
    }

    public double celsiumInFahrenheit (int celsiumTemp) {
        double fahrenheitTemp = (1.8 * celsiumTemp + 32);
        double scale = Math.pow(10, 2);
        return Math.ceil(fahrenheitTemp * scale) / scale;
    }


}
