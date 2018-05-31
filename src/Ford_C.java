public class Ford_C extends Car_V {
    private int serviceYears;
    private String model;

    public Ford_C(int capacity, int doors, String vehicleNo, boolean envFriendly, int serviceYears, String model) {
        super(capacity, doors, vehicleNo, envFriendly);
        this.serviceYears = serviceYears;
        this.model = model;
    }

}
