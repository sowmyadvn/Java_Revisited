public class Dog extends Animal {
    private int eyes;
    private int teeth;
    private int tail;
    private String breed;
    public Dog(int brain, int body, String name, int size, int weight, int eyes, int teeth, int tail, String breed) {
        super(brain, body, name, size, weight);
        this.eyes = eyes;
        this.breed = breed;
        this.tail = tail;
        this.teeth = teeth;
    }
}
