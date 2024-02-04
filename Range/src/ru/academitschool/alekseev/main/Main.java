package ru.academitschool.alekseev.main;

import ru.academitschool.alekseev.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(10.3, 56.6);
        double number1 = 10.7;

        System.out.printf("Длина диапазона от %.2f до %.2f равна %.2f", range1.getFrom(), range1.getTo(), range1.getLength());
        System.out.println();
        if (range1.isInside(number1)) {
            System.out.printf("Число %.2f входит в диапазон от %.2f до %.2f", number1, range1.getFrom(), range1.getTo());
        } else {
            System.out.printf("Число %.2f не входит в диапазон от %.2f до %.2f", number1, range1.getFrom(), range1.getTo());
        }

        System.out.println();
        range1.setFrom(15.2);
        range1.setTo(70.3);

        System.out.printf("Длина измененного диапазона от %.2f до %.2f равна %.2f", range1.getFrom(), range1.getTo(), range1.getLength());
        System.out.println();
        if (range1.isInside(number1)) {
            System.out.printf("Число %.2f входит в диапазон от %.2f до %.2f\n", number1, range1.getFrom(), range1.getTo());
        } else {
            System.out.printf("Число %.2f не входит в диапазон от %.2f до %.2f\n", number1, range1.getFrom(), range1.getTo());
        }

        System.out.println();
        Range range2 = new Range(69.4, 77.6);
        System.out.printf("Первый диапазон от %.2f до %.2f\n", range1.getFrom(), range1.getTo());
        System.out.printf("Второй диапазон от %.2f до %.2f\n", range2.getFrom(), range2.getTo());
        Range intersectionRange = range1.getIntersection(range2);
        if (intersectionRange == null) {
            System.out.println("Пересечения отсутствуют");
        } else {
            System.out.printf("Есть пересечение в диапазоне от %.2f до %.2f", intersectionRange.getFrom(), intersectionRange.getTo());
        }

        System.out.println();
        Range[] unificationRange = range1.getUnification(range2);
        System.out.print("Результат объединения двух диапазонов:");
        for (Range range : unificationRange) {
            System.out.printf(" [%.2f, %.2f]", range.getFrom(), range.getTo());
        }

        System.out.println();
        System.out.println();
        Range[] differenceRange = range1.getDifference(range2);
        System.out.print("Числовой интервал их разности:");
        if (differenceRange.length > 0) {
            for (Range range : differenceRange) {
                System.out.printf(" (%.2f; %.2f) ", range.getFrom(), range.getTo());
            }
        } else {
            System.out.print(" пустой диапазон.");
        }
    }
}
