import data.WeatherResponse;
import data.WeatherSavedData;
import db.SqlDb;

import java.util.List;

public class App {

    public static String delimiter = ";";

    public static void main(String[] args) {
        Weather weather = new Weather();
        SqlDb db = new SqlDb();
        db.initConnection();
        List<WeatherResponse> responseList = weather.getWeather();

        db.saveWeatherData(responseList);
        System.out.println("Response saved");

        System.out.println("Read saved data..");
        List<WeatherSavedData> savedDataList = db.readWeatherData();
        for (WeatherSavedData wr : savedDataList) {
            System.out.println("City: " + wr.getCity() +
                    " Date: " + wr.getDate() +
                    " Min temperature: " + wr.getMinTemperature() + " C" +
                    " Max temperature: " + wr.getMaxTemperature() + " C" +
                    " Weather text: " + wr.getDayInfo()
            );
        }
        db.closeConnection();
    }
}
