public class Main2 {
    public static void main(String[] args) {
        System.out.println("Main is powering up");
        Ford ford = new Ford();
        ford.startEngine();
        ford.accelerate(50);
        ford.brake();
        Carr car = new Carr("Car",2);
        car.startEngine();
        car.accelerate(20);
        car.brake();
    }
}

class Carr {

    private String name;
    private int wheels;
    private int cylinders;
    private int velocity;
    private boolean engine;

    public Carr(String name,int cylinders) {
        this.name = name;
        this.wheels = 4;
        this.cylinders = 3;
        this.engine = true;
        this.velocity = 0;
    }

    public String getName() {
        return name;
    }

    public int getWheels() {
        return wheels;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getVelocity() {
        return velocity;
    }

    public boolean isEngine() {
        return engine;
    }

    public void startEngine() {
        System.out.println("Engine is starting up.");
    }

    public void accelerate(int incr) {
        System.out.println("Accelerating...");
        this.velocity += incr;

        if(velocity < 0)
            this.velocity = 0;
        System.out.println("Velocity changed to "+ this.velocity);
    }

    public void brake() {
        System.out.println("Brake applied. Torque is working againsr movement");
    }
}

class Ford extends Carr{
    public Ford() {
        super("Fusion", 4);
    }

    @Override
    public void startEngine() {
        System.out.println("Ford fusion is starting now");
    }

    @Override
    public void accelerate(int incr) {
        System.out.println("Ford is accelerating");
        int vel = super.getVelocity();
        vel += incr;
        System.out.println("Ford is accelerating to:"+vel);
    }
}