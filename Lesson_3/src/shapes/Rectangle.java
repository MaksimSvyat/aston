package shapes;

public interface Rectangle {
    String getRectangleFillColor();

    String getRectangleBorderColor();

    double getLength();

    double getWidth();

    default double calculateRectanglePerimeter() {
        return 2 * (getLength() + getWidth());
    }

    default double calculateRectangleArea() {
        return getLength() * getWidth();
    }
}
