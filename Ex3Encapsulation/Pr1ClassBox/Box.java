package Ex3Encapsulation.Pr1ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        checkInput(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        checkInput(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        checkInput(height, "Height");
        this.height = height;
    }

    private void checkInput(double value, String name) {
        if (value < 1) {
            throw new IllegalArgumentException(String.format("%s cannot be zero or negative.", name));
        }
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateSurfaceArea() {
        return 2 * this.length * this.width + 2 * this.length * this.height + 2 * this.width * this.height;
    }

}
