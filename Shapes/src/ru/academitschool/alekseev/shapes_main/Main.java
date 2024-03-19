package ru.academitschool.alekseev.shapes_main;

import ru.academitschool.alekseev.shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(2),
                new Triangle(5, 2, 6, 44, 44, 1),
                new Rectangle(5, 10),
                new Circle(6),
                new Square(17),
                new Triangle(1, 1, 3, 4, 18, 9),
                new Rectangle(4, 12),
                new Circle(9)
        };

        Shape shapeWithMaxArea = getShapeWithMaxArea(shapes);

        System.out.println("Фигура с максимальной площадью:");

        if (shapeWithMaxArea != null) {
            System.out.printf("%s%nШирина: %.2f%nВысота: %.2f%nПлощадь: %.2f%nПериметр: %.2f%n",
                    shapeWithMaxArea, shapeWithMaxArea.getWidth(), shapeWithMaxArea.getHeight(),
                    shapeWithMaxArea.getArea(), shapeWithMaxArea.getPerimeter());
            System.out.println();
        }

        Shape shapeWithSecondPerimeter = getShapeWithSecondLargestPerimeter(shapes);

        System.out.println("Фигура со вторым по величине периметром:");

        if (shapeWithSecondPerimeter != null) {
            System.out.printf("%s%nШирина: %.2f%nВысота: %.2f%nПлощадь: %.2f%nПериметр: %.2f%n",
                    shapeWithSecondPerimeter, shapeWithSecondPerimeter.getWidth(), shapeWithSecondPerimeter.getHeight(),
                    shapeWithSecondPerimeter.getArea(), shapeWithSecondPerimeter.getPerimeter());
        }
    }

    public static Shape getShapeWithMaxArea(Shape[] shapes) {
        if (shapes.length == 0) {
            throw new IllegalArgumentException("В полученном массиве отсутствуют фигуры");
        }

        if (shapes.length == 1) {
            return shapes[0];
        }

        Arrays.sort(shapes, new AreaComparator());
        return shapes[shapes.length - 1];
    }

    public static Shape getShapeWithSecondLargestPerimeter(Shape[] shapes) {
        if (shapes.length < 2) {
            throw new IllegalArgumentException("В полученном массиве меньше двух фигур");
        }

        Arrays.sort(shapes, new PerimeterComparator());
        return shapes[shapes.length - 2];
    }
}
