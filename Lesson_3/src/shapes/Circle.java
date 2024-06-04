package shapes;

public interface Circle {
    String getCircleFillColor();

    String getCircleBorderColor();

    double getRadius();

    default double calculateCirclePerimeter() {
        return 2 * Math.PI * getRadius();
    }

    default double calculateCircleArea() {
        return Math.PI * getRadius() * getRadius();
    }
}
