public class Animal {
    private int brain;
    private int body;
    private String name;
    private int size;
    private int weight;


    public Animal(int brain, int body, String name, int size, int weight) {
        this.brain = brain;
        this.body = body;
        this.name = name;
        this.size = size;
        this.weight = weight;
    }

    public int getBrain() {
        return brain;
    }

    public int getBody() {
        return body;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }
}
