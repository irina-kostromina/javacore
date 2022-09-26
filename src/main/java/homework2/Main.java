package homework2;

public class Main {
    private static int arraySize = 4;

    public static void main (String[] args) {
        String[][] arr = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "4"}
        };

        System.out.println("Массив arr");
        app(arr);
        System.out.println();

        String[][] arrExSize1 = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "4"},
                {"4", "4", "4", "4"},
        };

        try {
            System.out.println("Массив arrExSize1");
            app(arrExSize1);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        String[][] arrExSize2 = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"}, {"2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "4"},
                {"4", "4", "4", "4"},
        };
        try {
            System.out.println("Массив arrExSize2");
            app(arrExSize2);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        String[][] arrExData = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "fs", "3"},
                {"4", "4", "4", "4"}
        };
        try {
            System.out.println("Массив arrExData");
            app(arrExData);
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void app (String[][] arr) {
        int sum = 0;
        int item;

        if (arr.length > arraySize) {
            throw new MyArraySizeException("Размер массива не соответствует заданию");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length > arraySize) {
                throw new MyArraySizeException("Размер массива не соответствует заданию");
            }
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                try {
                    item = Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(" В ячейке [" + i + "]" + "[" + j + "] " + "лежит непреобразуемая строка");
                }
                sum += item;
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Сумма элементов: " + sum);
    }
}
