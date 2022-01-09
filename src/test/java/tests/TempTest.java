package tests;

import base.BaseTest;
import model.CityPage;
import model.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class TempTest extends BaseTest {

    @Test
    public void testCompareMoscowTemp () {
        int celsiumCurrentTemp;
        int fahrenheitCurrentTemp;

        List<Integer> celsiumCurrentWeekTemp;
        List<Integer> fahrenheitCurrentWeekTemp;

        CityPage cityPage = new MainPage(getDriver())
                .searchCity("Moscow")
                .openCityPage();

        celsiumCurrentTemp = cityPage.getCurrentTemp();
        celsiumCurrentWeekTemp = cityPage.getCurrentWeekTemp();

        cityPage.imperialTempSwitch();

        fahrenheitCurrentTemp = cityPage.getCurrentTemp();
        fahrenheitCurrentWeekTemp = cityPage.getCurrentWeekTemp();

        Assert.assertTrue(cityPage.compareTemp(celsiumCurrentTemp, fahrenheitCurrentTemp));
        Assert.assertTrue(cityPage.compareWeekTemp(celsiumCurrentWeekTemp, fahrenheitCurrentWeekTemp));
    }

    @Test
    public void testCompareLondonTemp () {
        int celsiumCurrentTemp;
        int fahrenheitCurrentTemp;

        List<Integer> celsiumCurrentWeekTemp;
        List<Integer> fahrenheitCurrentWeekTemp;

        CityPage cityPage = new MainPage(getDriver())
                .searchCity("London")
                .openCityPage();

        celsiumCurrentTemp = cityPage.getCurrentTemp();
        celsiumCurrentWeekTemp = cityPage.getCurrentWeekTemp();

        cityPage.imperialTempSwitch();

        fahrenheitCurrentTemp = cityPage.getCurrentTemp();
        fahrenheitCurrentWeekTemp = cityPage.getCurrentWeekTemp();

        Assert.assertTrue(cityPage.compareTemp(celsiumCurrentTemp, fahrenheitCurrentTemp));
        Assert.assertTrue(cityPage.compareWeekTemp(celsiumCurrentWeekTemp, fahrenheitCurrentWeekTemp));
    }

    @Test
    public void testCompareYoshkarOlaTemp () {
        int celsiumCurrentTemp;
        int fahrenheitCurrentTemp;

        List<Integer> celsiumCurrentWeekTemp;
        List<Integer> fahrenheitCurrentWeekTemp;

        CityPage cityPage = new MainPage(getDriver())
                .searchCity("Yoshkar-Ola")
                .openCityPage();

        celsiumCurrentTemp = cityPage.getCurrentTemp();
        celsiumCurrentWeekTemp = cityPage.getCurrentWeekTemp();

        cityPage.imperialTempSwitch();

        fahrenheitCurrentTemp = cityPage.getCurrentTemp();
        fahrenheitCurrentWeekTemp = cityPage.getCurrentWeekTemp();

        Assert.assertTrue(cityPage.compareTemp(celsiumCurrentTemp, fahrenheitCurrentTemp));
        Assert.assertTrue(cityPage.compareWeekTemp(celsiumCurrentWeekTemp, fahrenheitCurrentWeekTemp));
    }


}
