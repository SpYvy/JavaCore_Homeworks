package homeworks.homework3.array_swapper;

import java.util.Arrays;

public class Main {
    static Integer[] integerArray = {1,2,3,4,5,6};
    static String[] stringArray = {"Первый","Второй","Третий","Четвертый"};
    static Byte[]  byteArray = {1,2,3,4};

    public static void main(String[] args) {
        SwapArrayElements<Object> swapArrayClass = new SwapArrayElements<>();

        try {
            swapArrayClass.arraySwap(integerArray, 1, 5);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Вы вышли за пределы массива");
        }
        System.out.println(Arrays.toString(integerArray));

        try {
            swapArrayClass.arraySwap(stringArray, 0,3);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Вы вышли за пределы массива");
        }
        System.out.println(Arrays.toString(stringArray));

        try {
            swapArrayClass.arraySwap(byteArray, 0,3);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Вы вышли за пределы массива");
        }
        System.out.println(Arrays.toString(byteArray));
    }
}