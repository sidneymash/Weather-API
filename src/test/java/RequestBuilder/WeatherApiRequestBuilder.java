package RequestBuilder;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static Common.BaseURI.API_KEY;
import static Common.BaseURI.baseURL;
import static PayloadBuilder.WeatherPayload.RegisterStation;
import static org.hamcrest.Matchers.equalTo;

public class WeatherApiRequestBuilder {


    static String StationID ;

    public static Response PostCreateStationResponse(String external_id, String name,float latitude,float longitude,int altitude){

        Response response =  RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations")
                .contentType(ContentType.JSON)
                .queryParam("appid", API_KEY)
                .log().all()
                .body(RegisterStation(external_id, name, latitude, longitude, altitude))
                .post()
                .then()
                .extract().response();
                StationID =response.jsonPath().getString("ID");

        return response;
    }
    public static Response getCreatedStationResponse(){

        Response response =  RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations/" + StationID)
                .contentType(ContentType.JSON)
                .queryParam("appid", API_KEY)
                .log().all()
                .get()
                .then()
                .extract().response();

        return response;
    }
    public static Response updateStationResponse(String external_id, String name,float latitude,float longitude,int altitude){

        Response response =  RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations/" + StationID)
                .contentType(ContentType.JSON)
                .queryParam("appid", API_KEY)
                .log().all()
                .body(RegisterStation(external_id, name, latitude, longitude, altitude))
                .put()
                .then()
                .extract().response();


        return response;
    }
    public static Response deleteCreatedStation(){

        Response response =  RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations/" + StationID)
                .contentType(ContentType.JSON)
                .queryParam("appid", API_KEY)
                .log().all()
                .delete()
                .then()
                .extract().response();

        return response;
    }

}
