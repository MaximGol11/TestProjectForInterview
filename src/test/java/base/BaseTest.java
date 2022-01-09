package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(driver, 10);
        }
        return wait;
    }

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://openweathermap.org");
    }

    @AfterTest
    protected void stopDriver() {
        driver.quit();
        wait = null;
    }

}
