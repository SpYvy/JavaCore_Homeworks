package homeworks.homework2;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("Сумма всех элементов массива = " + arrayGetSum(arraySizeException));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Сумма всех элементов массива = " + arrayGetSum(arrayDataException));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Сумма всех элементов массива = " + arrayGetSum(fineArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }
    private static String[][] arraySizeException = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}, {"1","2","3","4"}};
    private static String[][] arrayDataException = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","ЩЩЩЩЩ","3","4"}};
    private static String[][] fineArray = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};

    static void checkArraySize(String arr[][]) throws MyArraySizeException{
        if(arr.length != 4 || arr[0].length !=4){
            throw new MyArraySizeException();
        }
    }
    static int arrayGetSum(String arr[][]) throws MyArraySizeException, MyArrayDataException {
        checkArraySize(arr);
        int sum = 0;
        int i = 0;
        int j = 0;
        try {
            for (i = 0; i < arr.length; i++) {
                for (j = 0; j < arr[i].length; j++) {
                    sum = sum + Integer.parseInt(arr[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Ошибка массива в позиции " + i + "," + j);
        }
        return sum;
    }
}
