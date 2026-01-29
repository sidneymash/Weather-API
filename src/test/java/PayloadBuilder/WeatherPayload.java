package PayloadBuilder;

import org.json.simple.JSONObject;

public class WeatherPayload {

    public static JSONObject RegisterStation(String external_id, String name,float latitude,float
            longitude,int altitude) {

        JSONObject WeatherStation = new JSONObject();
        WeatherStation.put("external_id",external_id);
        WeatherStation.put("name",name);
        WeatherStation.put("latitude",latitude);
        WeatherStation.put("longitude",longitude);
        WeatherStation.put("altitude",altitude);

        return WeatherStation;
    }

    public static JSONObject updateStation(String external_id, String name,float latitude,float longitude,int altitude) {

        JSONObject WeatherStation = new JSONObject();
        WeatherStation.put("external_id",external_id);
        WeatherStation.put("name",name);
        WeatherStation.put("latitude",latitude);
        WeatherStation.put("longitude",longitude);
        WeatherStation.put("altitude",altitude);

        return WeatherStation;
    }

}
