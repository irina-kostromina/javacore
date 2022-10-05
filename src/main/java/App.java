import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class App {

    public static String delimiter = ";";

    public static void main(String[] args) {
        String fileName = "file.csv";
        AppData data = new AppData(
                new String[] {"value1, value2"},
                new int[][]{
                        {1,2},
                        {5,6}
                }
        );
        writeFile(fileName, data);

        AppData result = readFile(fileName);
    }

    public static void writeFile(String fileName, AppData appData) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < appData.header.length; i++) {
                stringBuilder.append(appData.header[i]);
                if (i != appData.header.length - 1) {
                    stringBuilder.append(delimiter);
                }
            }
            writer.write(stringBuilder.toString());

            for (int i = 0; i < appData.data.length; i++) {
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < appData.data[i].length; j++) {
                    str.append(appData.data[i][j]);
                    if (j != appData.data[i].length - 1) {
                        str.append(delimiter);
                    }
                }
                writer.write(str.toString());
            }
            writer.close();
        } catch (Exception e) {}
    }

    public static AppData readFile(String fileName) {
        AppData result = null;
        String[] headers = null;
        int[][] data;
        ArrayList<ArrayList<Integer>> dataValues = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String str = reader.readLine();
            if (str != null) {
                headers = str.split(delimiter);

                while ((str = reader.readLine()) != null) {
                    String[] values = str.split(delimiter);
                    ArrayList<Integer> item = new ArrayList<>();
                    for (String val : values) {
                        item.add(Integer.parseInt(val));
                    }
                    dataValues.add(item);
                }

                data = new int[dataValues.size()][headers.length];

                int i = 0;
                for (ArrayList<Integer> it : dataValues) {
                    for (int j = 0; j < it.size(); j++) {
                        data[i][j] = it.get(j);
                    }
                    i++;
                }

                result = new AppData(headers, data);
            }
        } catch (Exception e) {}

        return result;
    }
}
