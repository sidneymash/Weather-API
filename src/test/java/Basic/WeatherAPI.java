package Basic;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WeatherAPI {
    static String apiKey = "637564ac19c682d801b190268d429993";
    static String baseUrl = "http://api.openweathermap.org/data/3.0/stations";
    static String external_ID;

    @Test
public void createStation() {

        String payload = "{\n" +
                "  \"external_id\": \"SF_TEST001\",\n" +
                "  \"name\": \"San Francisco Test Station\",\n" +
                "  \"latitude\": 37.76,\n" +
                "  \"longitude\": -122.43,\n" +
                "  \"altitude\": 150\n" +
                "}";

        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + apiKey)
                .body(payload)
                .log().all()
                .post();

        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, 201);
    }
@Test
    public void retrieveStation(){

            Response response = RestAssured.given()
                    .baseUri(baseUrl)
                    .header("Content-Type", "application/json")
                    .header("Authorization", apiKey)
                    .log().all()
                    .get().prettyPeek();

            int actualStatusCode = response.statusCode();
            Assert.assertEquals(actualStatusCode, 200);
        }

    }
