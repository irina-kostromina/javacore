import data.WeatherResponse;

import java.util.List;

public class App {

    public static String delimiter = ";";

    public static void main(String[] args) {
        Weather weather = new Weather();

        List<WeatherResponse> responseList = weather.getWeather();
        for (WeatherResponse wr : responseList) {
            System.out.println("City: " + wr.getmCity() +
                    " Date: " + wr.getmDate() +
                    " Min temperature: " + wr.getTemperature().getMinimum().getValue() + " C" +
                    " Max temperature: " + wr.getTemperature().getMaximum().getValue() + " C" +
                    " Weather text: " + wr.getmDayInfo().getmPhrase()
            );
        }

    }
}
