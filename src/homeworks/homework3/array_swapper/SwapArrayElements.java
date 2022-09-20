package homeworks.homework3.array_swapper;

public class SwapArrayElements<T> {

    T holder;

    public T[] arraySwap(T[] array, int indexA, int indexB){
        holder = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = holder;
        return array;
    }
}