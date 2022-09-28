package homework3;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {

    public ArrayList<T> box;

    public Box(ArrayList<T> fruits) {
        box = fruits;
    }

    public void addFruits(ArrayList<T> fruits) {
        box.addAll(fruits);
    }

    public float getWeight() {
        float result = 0;

        for (Fruit f : box) {
            result += f.getWeight();
        }

        return result;
    }

    public <E extends Fruit> boolean compare(Box<E> b) {
        return box.equals(b.box);
    }

    public void sprinkleInto(Box<T> b) {
        b.box.addAll(box);
        box.clear();
    }

    public void add(T fruit) {
        box.add(fruit);
    }
}
