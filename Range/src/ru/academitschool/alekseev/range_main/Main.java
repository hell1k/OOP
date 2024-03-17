package ru.academitschool.alekseev.range_main;

import ru.academitschool.alekseev.range.Range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(10.3, 56.6);
        double number1 = 10.7;

        System.out.println("Начало диапазона: " + range1.getFrom());
        System.out.println("Конец диапазона: " + range1.getTo());
        System.out.printf("Длина диапазона %s равна %.2f%n", range1, range1.getLength());

        if (range1.isInside(number1)) {
            System.out.printf("Число %.2f входит в диапазон %s%n", number1, range1);
        } else {
            System.out.printf("Число %.2f не входит в диапазон %s%n", number1, range1);
        }

        range1.setFrom(15.2);
        range1.setTo(40.3);
        System.out.printf("Длина измененного диапазона %s равна %.2f%n", range1, range1.getLength());

        if (range1.isInside(number1)) {
            System.out.printf("Число %.2f входит в диапазон %s%n", number1, range1);
        } else {
            System.out.printf("Число %.2f не входит в диапазон %s%n", number1, range1);
        }

        System.out.println();
        Range range2 = new Range(10.4, 37.6);
        System.out.println("Первый диапазон " + range1);
        System.out.println("Второй диапазон " + range2);

        Range intersection = range1.getIntersection(range2);

        if (intersection == null) {
            System.out.println("Пересечение отсутствует");
        } else {
            System.out.printf("Результат пересечения двух диапазонов %s%n", intersection);
        }

        Range[] union = range1.getUnion(range2);
        System.out.println("Результат объединения двух диапазонов: " + Arrays.toString(union));

        Range[] difference = range1.getDifference(range2);
        System.out.println("Результат разности двух диапазонов: " + Arrays.toString(difference));
    }
}
