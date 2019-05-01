public class Challenge_40 {
    public static void main(String[] args) {
        Ford_C ford = new Ford_C(2,2,"12345",true,5,"Mustang");

        ford.accelerate(50);
        ford.changeDirection(45);
        ford.move(ford.getCurrentVelocity(),ford.getCurrentDirection());
        ford.accelerate(-35);
        ford.move(ford.getCurrentVelocity(),ford.getCurrentDirection());

    }
}
