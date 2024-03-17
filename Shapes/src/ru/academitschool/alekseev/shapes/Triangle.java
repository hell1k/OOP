package ru.academitschool.alekseev.shapes;

public class Triangle implements Shape{
    private final double x1;
    private final double y1;

    private final double x2;
    private final double y2;

    private final double x3;
    private final double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;

        this.x2 = x2;
        this.y2 = y2;

        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    private static double getSideLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    @Override
    public double getArea() {
        double sideA = getSideLength(x1, y1, x2, y2);
        double sideB = getSideLength(x2, y2, x3, y3);
        double sideC = getSideLength(x1, y1, x3, y3);

        double halfPerimeter = (sideA + sideB + sideC) / 2;

        return Math.sqrt(halfPerimeter * (halfPerimeter - sideA) *
                (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }

    @Override
    public double getPerimeter() {
        return getSideLength(x1, y1, x2, y2) + getSideLength(x2, y2, x3, y3) + getSideLength(x1, y1, x3, y3);
    }

    @Override
    public String toString() {
        return "Треугольник с координатами: (" + x1 + "; " + y1 +
                "), (" + x2 + "; " + y2 +
                "), (" + x3 + "; " + y3 + ")";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) object;

        return triangle.x1 == x1 &&
                triangle.y1 == y1 &&
                triangle.x2 == x2 &&
                triangle.y2 == y2 &&
                triangle.x3 == x3 &&
                triangle.y3 == y3;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(y1);

        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(y2);

        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y3);

        return hash;
    }
}
