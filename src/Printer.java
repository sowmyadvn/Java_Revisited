public class Printer {
    private String brand = "hp";
    private int pagesPrinted = 0;
    private int tonerLevel = 100;
    private boolean duplexPrinter=true;

    public Printer(String brand, int pagesPrinted, int tonerLevel, boolean duplexPrinter) {
        this.brand = brand;
        this.pagesPrinted = pagesPrinted;
        this.tonerLevel = tonerLevel;
        this.duplexPrinter = duplexPrinter;
    }

    public void fillToner(int level) {
        if(level > 0 && level <= 100) {
            this.tonerLevel += level;
            if (this.tonerLevel > 100) {
                this.tonerLevel = 100;
            }
        }
        System.out.println("Toner filled.Level:"+this.tonerLevel);
    }

    public boolean isDuplexPrinter() {
        return this.duplexPrinter;
    }

    public void printPages(int newPages) {
        if(newPages > 0 && this.tonerLevel > 0 ) {
            this.pagesPrinted += newPages;
            tonerLevel -= 5;
        }
        System.out.println("Pages printed:"+this.pagesPrinted+" Toner level:"+tonerLevel);
    }

    public int getPagesPrinted() {
        System.out.println(" Pages printed:"+this.pagesPrinted);
        return this.pagesPrinted;
    }


}
