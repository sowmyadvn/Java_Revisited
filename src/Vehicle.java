public class Vehicle {
    private int capacity;
    private boolean envFriendly;

    public Vehicle(int capacity, boolean envFriendly) {
        this.capacity = capacity;
        this.envFriendly = envFriendly;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public boolean getEnvFriendly() {
        return this.envFriendly;
    }


}
