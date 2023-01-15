package data;

public class WeatherSavedData {

    private final String date;
    private final Double minTemperature;
    private final Double maxTemperature;
    private final String dayInfo;
    private final String city;

    public WeatherSavedData(String city, String date, String dayInfo, Double minTemperature, Double maxTemperature) {
        this.date = date;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.dayInfo = dayInfo;
        this.city = city;
    }

    public String getDate() {
        return date;
    }


    public Double getMinTemperature() {
        return minTemperature;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public String getDayInfo() {
        return dayInfo;
    }

    public String getCity() {
        return city;
    }
}
