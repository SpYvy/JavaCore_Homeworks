package homeworks.homework3.fruit_box;

public class Box <T extends Fruit> {
    T[] fruitArray;
    public Box(T[] fruitArray) {
        this.fruitArray = fruitArray;
    }
    public float getWeight() {
        float result = 0.0f;
        T[] fruitArray = getFruitArray();
        for (int i = 0; i < fruitArray.length; i++) {
            T t = fruitArray[i];
            if(t!=null) {
                float value = t.getFruitWeight();
                result = result + value;
            }
        }
        return result;
    }

    public boolean compare(Box<? extends Fruit> another) {
        if(this.getWeight() == another.getWeight()){
            return true;
        }
        return false;
    }

    public void pourFromAnotherBox(Box<T> another){
        System.out.println("В коробке откуда пересыпают до " + another.getWeight());
        System.out.println("В коробке куда нужно пересыпают до " + this.getWeight());
        for(int i = 0; i < another.getFruitArray().length; i++){
            if(another.getFruitArray()[i] != null) {
                this.getFruitArray()[getSize()] = another.getFruitArray()[i];
                another.getFruitArray()[i] = null;
            }
        }
        System.out.println("В коробке откуда пересыпают после " + another.getWeight());
        System.out.println("В коробке куда пересыпают после " + this.getWeight());
    }

    public void add(T t){ // добавить элемент в первую свободную ячейку массива
        int value = 0;
        int i = 0;
        while (this.getFruitArray()[i] != null) {
            value = i + 1;
            i++;
        }
        this.getFruitArray()[value] = t;
    }

    public int getSize(){
        int result = 0;
        for(T t : getFruitArray()){
            if(t!=null) result++;
        }
        return result;
    }

    public T[] getFruitArray() {
        return fruitArray;
    }
}