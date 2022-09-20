package homeworks.homework3.fruit_box;

public class Main {

    public static void main(String[] args) {

        Orange[] oranges = new Orange[20];

        Orange orange0 = new Orange("orange", 1.5f); oranges[0] = orange0;
        Orange orange1 = new Orange("orange", 1.5f); oranges[1] = orange1;
        Orange orange2 = new Orange("orange", 1.5f); oranges[2] = orange2;
        Orange orange3 = new Orange("orange", 1.5f); oranges[3] = orange3;

        Box<Orange> orangeBox = new Box<>(oranges);

        System.out.println(String.valueOf(orangeBox.getWeight()));

        Apple[] apples = new Apple[20];
        Apple apple0 = new Apple("apple", 1.0f); apples[0] = apple0;
        Apple apple1 = new Apple("apple", 1.0f); apples[1] = apple1;
        Apple apple2 = new Apple("apple", 1.0f); apples[2] = apple2;
        Apple apple3 = new Apple("apple", 1.0f); apples[3] = apple3;
        Apple apple4 = new Apple("apple", 1.0f); apples[4] = apple4;
        Apple apple5 = new Apple("apple", 1.0f); apples[5] = apple5;

        Apple[] threeApples = new Apple[20];
        threeApples[0] = apple0;
        threeApples[1] = apple1;
        threeApples[2] = apple2;

        Box<Apple> appleBox = new Box<>(apples);

        System.out.println(String.valueOf(appleBox.getWeight()));

        if (appleBox.compare(orangeBox)){
            System.out.println("Ящики равны");
        } else {
            System.out.println("Ящики не равны");
        }

        Box<Apple> appleBox1 = new Box<>(threeApples);
        appleBox1.pourFromAnotherBox(appleBox);

        appleBox1.add(apple0);
    }
}