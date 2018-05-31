public class Wall {
    private String color;
    private int height;

    private Wall(String color, int height) {
        this.color = color;
        this.height = height;
    }

    public Wall getWallInfo() {
        Wall testWall = new Wall("Green",108);
        return testWall;
    }


}
