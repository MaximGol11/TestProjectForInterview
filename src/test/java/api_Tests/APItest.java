package api_Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.WeatherHourly;

import java.util.List;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;


public class APItest {
    private static final String URL = "https://api.openweathermap.org";
    private static final String API_KEY = "677bcd2a86842a8704b0099b932bde19";
    private static final String CITY = "Yoshkar-Ola";

    @Test
    public void testCheckCityName() {
        RestAssured
                .given()
                .when()
                .get(URL + "/data/2.5/weather?q=" + CITY + "&appid=" + API_KEY)
                .then().assertThat().statusCode(200)
                .and()
                .body("name", equalTo(CITY));
    }

    @Test
    public void testYohkarOlaTemp(){
        List <WeatherHourly> weathers = given()
                .contentType(ContentType.JSON)
                .when().get(URL + "/data/2.5/onecall/timemachine?lat=56.6388&lon=47.8908&dt=1641709387&appid=" + API_KEY)
                .then().statusCode(200)
                .extract().jsonPath().getList("hourly", WeatherHourly.class);

        for (WeatherHourly weather : weathers) {
            System.out.println(weather.getTemp());
            Assert.assertTrue(weather.getTemp() >= 250.0);
        }
    }
}
