public class Encapsulation_49 {
    public static void main(String[] args) {
        Printer printer = new Printer("Sony",200, 80, true);
        printer.getPagesPrinted();
        printer.printPages(20);
        printer.fillToner(20);
        printer.getPagesPrinted();

    }
}
