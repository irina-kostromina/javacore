package homework3;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());

        ArrayList<Orange> oranges = new ArrayList<>();
        oranges.add(new Orange());
        oranges.add(new Orange());
        oranges.add(new Orange());

        Box<Apple> appleBox = new Box<>(apples);
        Box<Orange> orangeBox = new Box<>(oranges);

        System.out.println("Вес коробки appleBox: " + appleBox.getWeight());
        System.out.println("Вес коробки orangeBox: " + orangeBox.getWeight());

        boolean result = appleBox.compare(orangeBox);
        System.out.println("Результат сравнения 1: " + result);
        result = appleBox.compare(appleBox);
        System.out.println("Результат сравнения 2: " + result);

        System.out.println("Вес до добавления апельсина: " + orangeBox.getWeight());
        orangeBox.add(new Orange());
        System.out.println("Вес после добавления апельсина: " + orangeBox.getWeight());

        Box<Apple> emptyBox = new Box<>(new ArrayList<>());
        System.out.println("Результат до пересыпания(appleBox): " + appleBox.box.size());
        System.out.println("Результат до пересыпания(emptyBox): " + emptyBox.box.size());
        appleBox.sprinkleInto(emptyBox);
        System.out.println("Результат после пересыпания(appleBox): " + appleBox.box.size());
        System.out.println("Результат после пересыпания(emptyBox): " + emptyBox.box.size());
    }
}
