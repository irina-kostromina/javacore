import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class App {

    public static String delimiter = ";";

    public static void main(String[] args) {
        Weather weather = new Weather();

        String weatherStr = weather.getWeather();
        System.out.println(weatherStr);
    }
}
