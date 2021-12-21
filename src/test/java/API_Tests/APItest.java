package API_Tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APItest {
    private String API = "677bcd2a86842a8704b0099b932bde19";

    @Test
    public void testWeather() {
        given()
                .when()
                .get("https://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=677bcd2a86842a8704b0099b932bde19")
                .then()
                .log()
                .all();
    }

}
