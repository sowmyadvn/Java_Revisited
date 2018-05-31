public class SofaSet {
    private String material;
    private int height;
    private int width,length;
    private int capacity;

    private SofaSet(String material, int height,int length, int width, int capacity) {
        this.material = material;
        this.height = height;
        this.width = width;
        this.capacity = capacity;
    }

    public SofaSet getSofaSetInfo() {
        SofaSet sofaSet = new SofaSet("Faux Leather",20, 50, 10,6);
        return sofaSet;
    }
}
