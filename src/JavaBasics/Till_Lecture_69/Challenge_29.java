public class Challenge_29 {
    public static void main(String[] args) {
        double inchToCenti = calcFeetAndInchesToCentimeters(29);
        System.out.println(inchToCenti);

    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if (feet >= 0 && (inches >= 0 && inches <= 12)) {
            double feetToCenti = feet * 30.48 + inches * 2.54;
            return feetToCenti;
        }
        else
            return -1;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches >= 0) {
            double feet = (int)(inches/12);
            inches = inches%12;
            double feetToCentiTest = calcFeetAndInchesToCentimeters(feet,inches);
            return feetToCentiTest;
        }
        return -1;
    }
}
