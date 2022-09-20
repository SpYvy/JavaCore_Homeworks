package homeworks.homework3.fruit_box;

public abstract class Fruit {

    private String fruitName;
    private float fruitWeight;

    public Fruit(String fruitName, float fruitWeight) {
        this.fruitName = fruitName;
        this.fruitWeight = fruitWeight;
    }

    public float getFruitWeight() {
        return fruitWeight;
    }

    public String getFruitName() {
        return fruitName;
    }
}