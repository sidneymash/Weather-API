package Tests;

import RequestBuilder.WeatherApiRequestBuilder;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class WeatherApiTest {

    @Test(priority = 1)
    public void createWeatherStationTest() {
        WeatherApiRequestBuilder.PostCreateStationResponse(
                "SF_TEST001",
                        "San Francisco Test Station",
                        37.76f,
                        -122.43f,
                        150
                )
                .then()
                .log().all()
                .assertThat()
                .statusCode(201);

    }
    @Test(priority = 2)
    public void getWeatherStationTest() {
        WeatherApiRequestBuilder.getCreatedStationResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);

    }
    @Test(priority = 3)
    public void updateWeatherStationTest() {
        WeatherApiRequestBuilder.updateStationResponse(
                        "SF_TEST001_0001",
                        "South African Test Station",
                        40.76f,
                        -122.90f,
                        143
                )
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);

    }
    @Test(priority = 4)
    public void deleteWeatherStation() {
        WeatherApiRequestBuilder.deleteCreatedStation()
                .then()
                .log().all()
                .assertThat()
                .statusCode(204);

    }

}
