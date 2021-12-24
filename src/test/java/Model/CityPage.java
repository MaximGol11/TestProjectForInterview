package Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CityPage extends BaseModel{

    @FindBy (xpath = "//div[contains(text(), 'Imperial')]")
    private WebElement imperialTempSwitch;

    @FindBy (xpath = "//div[@class='current-temp']")
    private WebElement currentTemp;

    @FindBy (xpath = "//div[@class='day-list-values']//div//span")
    private List<WebElement> weekTemp;

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

    //возможно было сделать это более изящно, но больше проблем доставила конвертация температур.
    public List<Integer> getCurrentWeekTemp () {

        List<String> stringListTempClear = new ArrayList<>();
        List<List<String>> stringList = new ArrayList<>();
        List<String> separatedStringList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();

        List<String> stringListTempFull = weekTemp.stream().map(WebElement::getText).collect(Collectors.toList());

        for (String s : stringListTempFull) {
            stringListTempClear.add(s.replaceAll("[^0-9, -]", ""));
        }
        for (String s : stringListTempClear) {
            String[] b = s.split("  ");
            for (int k = 0; k < b.length; k++) {
                separatedStringList = Arrays.stream(b).collect(Collectors.toList());
            }
            stringList.add(separatedStringList);
        }

        for (List<String> list : stringList) {
            for (String s : list) {
                intList.add(Integer.parseInt(s));
            }
        }
        return intList;
    }

    //Конвертация температур может работать некорректно. В идеале сравнивать температуры в диапазоне +- 1 градус.
    public boolean compareTemp (int celsiumCurrentTemp, int fahrenheitCurrentTemp) {
        return (Math.ceil(celsiumCurrentTemp + 273.15) == Math.ceil((fahrenheitCurrentTemp + 459.67) * 5 / 9));
    }

    public boolean compareWeekTemp (List<Integer> celsiumWeekCurrentTemp, List<Integer> fahrenheitCurrentTemp) {
        List<Double> celsiumInKelvin = new ArrayList<>();
        List<Double> fahrenheitInKelvin = new ArrayList<>();

        for (int i = 0; i < celsiumWeekCurrentTemp.size(); i++) {
            celsiumInKelvin.add(Math.ceil(celsiumWeekCurrentTemp.get(i) + 273.15));
            fahrenheitInKelvin.add(Math.ceil((fahrenheitCurrentTemp.get(i) + 459.67) * 5.0 / 9.0));
        }
        return celsiumInKelvin.equals(fahrenheitInKelvin);
    }
}
