package shapes;

public class Shape implements Circle, Rectangle, Triangle {
    private final double radius;
    private final String CircleFillColor;
    private final String CircleBorderColor;
    private final double length;
    private final double width;
    private final String RectangleFillColor;
    private final String RectangleBorderColor;
    private final double side1;
    private final double side2;
    private final double side3;
    private final String TriangleFillColor;
    private final String TriangleBorderColor;

    public Shape(double radius, String CircleFillColor, String CircleBorderColor, double length, double width,
                 String RectangleFillColor, String RectangleBorderColor, double side1, double side2, double side3,
                 String TriangleFillColor, String TriangleBorderColor) {
        this.radius = radius;
        this.CircleFillColor = CircleFillColor;
        this.CircleBorderColor = CircleBorderColor;
        this.length = length;
        this.width = width;
        this.RectangleFillColor = RectangleFillColor;
        this.RectangleBorderColor = RectangleBorderColor;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.TriangleFillColor = TriangleFillColor;
        this.TriangleBorderColor = TriangleBorderColor;
    }

    @Override
    public String getCircleFillColor() {
        return CircleFillColor;
    }

    @Override
    public String getCircleBorderColor() {
        return CircleBorderColor;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public String getRectangleFillColor() {
        return RectangleFillColor;
    }

    @Override
    public String getRectangleBorderColor() {
        return RectangleBorderColor;
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public String getTriangleFillColor() {
        return TriangleFillColor;
    }

    @Override
    public String getTriangleBorderColor() {
        return TriangleBorderColor;
    }

    @Override
    public double getSide1() {
        return side1;
    }

    @Override
    public double getSide2() {
        return side2;
    }

    @Override
    public double getSide3() {
        return side3;
    }

    public void printShapesInfo() {
        System.out.println("Круг - Площадь: " + calculateCircleArea() + ", Периметр: " + calculateCirclePerimeter() +
                ", Цвет заливки: " + getCircleFillColor() + ", Цвет границы: " + getCircleBorderColor());
        System.out.println("Прямоугольник - Площадь: " + calculateRectangleArea() + ", Периметр: " + calculateRectanglePerimeter() +
                ", Цвет заливки: " + getRectangleFillColor() + ", Цвет границы: " + getRectangleBorderColor());
        System.out.println("Треугольник - Площадь: " + calculateTriangleArea() + ", Периметр: " + calculateTrianglePerimeter() +
                ", Цвет заливки: " + getTriangleFillColor() + ", Цвет границы: " + getTriangleBorderColor());
    }
}
