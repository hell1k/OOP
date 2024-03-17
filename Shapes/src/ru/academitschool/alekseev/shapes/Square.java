package ru.academitschool.alekseev.shapes;

public class Square implements Shape {
    private final double sideLength;

    public Square(double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Строны квадрата должны быть больше нуля");
        }

        this.sideLength = sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return Math.pow(sideLength, 2);
    }

    @Override
    public double getPerimeter() {
        return sideLength * 4;
    }

    @Override
    public String toString() {
        return "Квадрат со стороной " + sideLength;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        Square square = (Square) object;

        return sideLength == square.sideLength;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(sideLength);
    }
}
