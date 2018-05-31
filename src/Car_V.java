public class Car_V extends Vehicle {

    private int doors;
    private String vehicleNo;
    private int gears;
    private int currentGear;
    private int currentVelocity, currentDirection;

    public Car_V(int capacity,int doors,String vehicleNo, boolean envFriendly) {
        super(capacity, envFriendly);
        this.doors = doors;
        this.vehicleNo = vehicleNo;
        this.gears = 4;

        this.currentGear = 0;
        this.currentDirection = 0;
        this.currentVelocity = 0;
    }

    public void setCurrentVelocity(int currentVelocity) {
        this.currentVelocity = currentVelocity;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }

    public int getCurrentVelocity()
    {
        return currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public int getCurrentGear() {
        return currentGear;
    }
    public void move(int currentVelocity, int currentDirection) {
        System.out.println("Car is moving with velocity"+currentVelocity+" with direction:"+currentDirection+" degrees");
    }

    public void accelerate(int velocity) {
        this.currentVelocity += velocity;
        if(currentVelocity < 0) {
            currentVelocity = 0;
        }
        System.out.println("Current velocity is:"+currentVelocity+" miles per hour");
        changeGear(currentVelocity);

    }

    private void changeGear(int currentVelocity) {
        if (currentVelocity > 90) {
            setCurrentGear(4);
            System.out.println("Car is in gear 4");
        }
        else if (currentVelocity > 60) {
            setCurrentGear(3);
            System.out.println("Car is in gear 3");
        }
        else if (currentVelocity > 30) {
            setCurrentGear(2);
            System.out.println("Car is in gear 2");
        }
        else if (currentVelocity >0) {
            setCurrentGear(1);
            System.out.println("Car is in gear 1");
        }
        else {
            setCurrentGear(0);
            System.out.println("Car is stopped");
        }
        }

        public void changeDirection(int currentDirection) {
            this.currentDirection += currentDirection;
            System.out.println("Steering is turned "+ this.currentDirection+" degrees");
    }
}
