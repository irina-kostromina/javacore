import okhttp3.*;

import java.io.IOException;

public class Weather {
    private static final String URL = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/";
    private static final String ACCUWEATHER_API_KEY = "fGx740IlEfVlPgdMpFklUNrFqVPULxZU";
    private static final String COUNTRY_ID = "RU";
    private static final String SAINTS_P_ID = "295212";

    private final OkHttpClient client = new OkHttpClient();

    public String getWeather() {
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

        return result;
    }
}
