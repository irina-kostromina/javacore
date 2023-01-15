import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.WeatherResponse;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Weather {
    private static final String URL = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/";
    private static final String ACCUWEATHER_API_KEY = "fGx740IlEfVlPgdMpFklUNrFqVPULxZU";
    private static final String COUNTRY_ID = "RU";
    private static final String SAINTS_P_ID = "295212";

    private static final String CITY = "Saint Petersburg";

    private final OkHttpClient client = new OkHttpClient();

    public List<WeatherResponse> getWeather() {
        String result = "";
        HttpUrl.Builder urlBuilder
                = HttpUrl.parse(URL + SAINTS_P_ID).newBuilder();
        urlBuilder.addQueryParameter("apikey", ACCUWEATHER_API_KEY);
        urlBuilder.addQueryParameter("details", "true");
        urlBuilder.addQueryParameter("metric", "true");

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            result = response.body().string();
            System.out.println("Success response");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        List<WeatherResponse> responseList = new ArrayList<>();
        try {
            JsonNode forecastsNodes = objectMapper.readTree(result).at("/DailyForecasts");

            for (Iterator<JsonNode> it = forecastsNodes.elements(); it.hasNext(); ) {
                JsonNode n = it.next();
                WeatherResponse weatherResponse = objectMapper.treeToValue(n, WeatherResponse.class);
                weatherResponse.setmCity("Saint Petersburg");
                responseList.add(weatherResponse);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


        return responseList;
    }
}
