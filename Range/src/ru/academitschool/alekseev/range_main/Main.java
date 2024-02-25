package ru.academitschool.alekseev.range_main;

import ru.academitschool.alekseev.range.Range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(10.3, 56.6);
        double number1 = 10.7;

        System.out.printf("Длина диапазона %s равна %.2f%n", range1.toString(), range1.getLength());

        if (range1.isInside(number1)) {
            System.out.printf("Число %.2f входит в диапазон %s%n", number1, range1.toString());
        } else {
            System.out.printf("Число %.2f не входит в диапазон %s%n", number1, range1.toString());
        }

        range1.setFrom(15.2);
        range1.setTo(60.3);
        System.out.printf("Длина измененного диапазона %s равна %.2f%n", range1.toString(), range1.getLength());

        if (range1.isInside(number1)) {
            System.out.printf("Число %.2f входит в диапазон %s%n", number1, range1.toString());
        } else {
            System.out.printf("Число %.2f не входит в диапазон %s%n", number1, range1.toString());
        }

        System.out.println();
        Range range2 = new Range(59.4, 77.6);
        System.out.println("Первый диапазон " + range1.toString());
        System.out.println("Второй диапазон " + range2.toString());
        Range intersection = range1.getIntersection(range2);

        if (intersection == null) {
            System.out.println("Пересечения отсутствуют");
        } else {
            System.out.printf("Есть пересечение в диапазоне %s%n", intersection.toString());
        }

        Range[] union = range1.getUnion(range2);
        System.out.println("Результат объединения двух диапазонов: " + Arrays.toString(union));
        Range[] difference = range1.getDifference(range2);
        System.out.println("Результат разности двух диапазонов: " + Arrays.toString(difference));
    }
}
