public class Circle {
    private int centerX;
    private int centerY;
    private int radius;

    public Circle() {
        centerX = 0;
        centerY = 0;
        radius = 1;
    }

    public Circle(int centerX, int centerY, int radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative.");
        }

        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public boolean contains(double x, double y) {
        double dx = x - centerX;
        double dy = y - centerY;

        return dx * dx + dy * dy <= radius * radius;
    }
}