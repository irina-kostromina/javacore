package db;

import data.WeatherResponse;
import data.WeatherSavedData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlDb {

    private Connection mConnection;

    public void initConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            mConnection = DriverManager.getConnection("jdbc:sqlite:homework8.db");
            Statement state = mConnection.createStatement();
            state.execute("CREATE TABLE IF NOT EXISTS weather (city text, localDate text, weatherText text, minTemperature double, maxTemperature double)");
            state.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() {
        if (mConnection != null) {
            try {
                mConnection.close();
                mConnection = null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void saveWeatherData(List<WeatherResponse> data) {
        if (mConnection != null) {
            try {
                Statement state = mConnection.createStatement();
                String sql;
                for (WeatherResponse w : data) {
                    sql = "INSERT INTO weather VALUES ('" + w.getmCity() + "', '" + w.getmDate() + "', '" + w.getmDayInfo().getmPhrase() + "', " + w.getTemperature().getMinimum().getValue() + ", " + w.getTemperature().getMaximum().getValue() + ")";
                    state.executeUpdate(sql);
                }
                state.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<WeatherSavedData> readWeatherData() {
        List<WeatherSavedData> result = new ArrayList<>();

        if (mConnection != null) {
            try {
                Statement state = mConnection.createStatement();
                String sql = "SELECT * FROM weather";
                ResultSet set = state.executeQuery(sql);
                while (set.next()) {
                    WeatherSavedData w = new WeatherSavedData(set.getString("city"),
                            set.getString("localDate"),
                            set.getString("weatherText"),
                            set.getDouble("minTemperature"),
                            set.getDouble("maxTemperature"));
                    result.add(w);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }
}
