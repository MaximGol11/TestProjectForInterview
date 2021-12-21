package Tests;

import Base.BaseTest;
import Model.CityPage;
import Model.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TempTest extends BaseTest {

    @Test
    public void testCompareMoscowTemp () {
        int celsiumCurrentTemp;
        int fahrenheitCurrentTemp;

        CityPage cityPage = new MainPage(getDriver())
                .searchCity("Moscow")
                .openCityPage();
        celsiumCurrentTemp = cityPage.getCurrentTemp();

        cityPage.imperialTempSwitch();

        fahrenheitCurrentTemp = cityPage.getCurrentTemp();

        Assert.assertEquals(cityPage.celsiumInFahrenheit(celsiumCurrentTemp),fahrenheitCurrentTemp );
    }

}
