package ru.academitschool.alekseev.shapes;

public class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        if (width <= 0) {
            throw new IllegalArgumentException("Ширина прямоугольника должна быть больше нуля. Ширина: + " + width);
        }

        if (height <= 0) {
            throw new IllegalArgumentException("Высота прямоугольника должна быть больше нуля. Высота: " + height);
        }

        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (height + width);
    }

    @Override
    public String toString() {
        return "Прямоугольник с шириной " + width + " и высотой " + height;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) object;
        return rectangle.width == width && rectangle.height == height;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Double.hashCode(width);
        hash = prime * hash + Double.hashCode(height);

        return hash;
    }
}
