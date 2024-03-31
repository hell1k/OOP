package ru.academitschool.alekseev.shapes;

public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть больше нуля. Радиус: " + radius);
        }

        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getWidth() {
        return radius * 2;
    }

    @Override
    public double getHeight() {
        return radius * 2;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Окружность с радиусом " + radius;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Circle circle = (Circle) object;
        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(radius);
    }
}
