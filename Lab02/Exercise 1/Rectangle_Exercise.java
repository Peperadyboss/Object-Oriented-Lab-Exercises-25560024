public class Rectangle_Exercise {

    private double width;
    private double height;

    public Rectangle_Exercise() {
        width = 1;
        height = 1;
    }

    public Rectangle_Exercise(double width, double height) {
        this.width = (width > 0) ? width : 1;
        this.height = (height > 0) ? height : 1;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public void displayInfo() {
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + area());
        System.out.println("Perimeter: " + perimeter());
    }
}
