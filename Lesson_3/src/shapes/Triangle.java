package shapes;

public interface Triangle {
    String getTriangleFillColor();

    String getTriangleBorderColor();

    double getSide1();

    double getSide2();

    double getSide3();

    default double calculateTrianglePerimeter() {
        return getSide1() + getSide2() + getSide3();
    }

    default double calculateTriangleArea() {
        double s = (getSide1() + getSide2() + getSide3()) / 2;
        return Math.sqrt(s * (s - getSide1()) * (s - getSide2()) * (s - getSide3()));
    }
}
