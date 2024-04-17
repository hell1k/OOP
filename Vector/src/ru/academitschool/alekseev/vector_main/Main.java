package ru.academitschool.alekseev.vector_main;

import ru.academitschool.alekseev.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(3);
        System.out.println("Vector1 " + vector1 + ". Длина вектора " + vector1.getSize());
        double[] array1 = {4, 6};
        Vector vector2 = new Vector(array1);
        System.out.println("Vector2 " + vector2 + ". Длина вектора " + vector2.getSize());
        double[] array2 = {1, 5, 2};
        Vector vector3 = new Vector(5, array2);
        System.out.println("Vector3 " + vector3 + ". Длина вектора " + vector3.getSize());
        Vector vector4 = new Vector(vector2);
        System.out.println("Vector4 " + vector4 + ". Длина вектора " + vector4.getSize());
        System.out.println();
        System.out.println("Получение и установка компоненты вектора по индексу:");
        System.out.println("Компонент 1 из Vector2: " + vector2.getComponent(1));
        vector2.setComponent(1, 12);
        System.out.println("Компонент 1 из Vector2 после изменения: " + vector2.getComponent(1));
        System.out.println();
        System.out.println("Прибавление к вектору другого вектора:");
        System.out.println(vector3 + " + " + vector4 + " = " + vector3.add(vector4));
        System.out.println();
        double[] array3 = {-3, 4, 8, 2, 1};
        Vector vector5 = new Vector(array3);
        System.out.println("Вычитание из вектора другого вектора:");
        System.out.println(vector3 + " - " + vector5 + " = " + vector3.subtract(vector5));
        System.out.println();
        int scalar = 3;
        System.out.println("Умножение вектора на скаляр:");
        System.out.println(vector5 + " x " + scalar + " = " + vector5.multiplyByScalar(scalar));
        System.out.println();
        System.out.println("Разворот вектора " + vector5 + ": " + vector5.reverse());
        System.out.println();
        System.out.println("Проверка равенства векторов:");
        System.out.println(vector1 + " == " + vector2 + ": " + vector1.equals(vector2));
        Vector vector6 = new Vector(vector4);
        System.out.println(vector6 + " == " + vector4 + ": " + vector6.equals(vector4));
        System.out.println();
        System.out.println("Сложение двух векторов с созданием нового вектора:");
        Vector vector7 = Vector.getSum(vector2, vector3);
        System.out.println(vector2 + " + " + vector3 + " = " + vector7);
        System.out.println();
        System.out.println("Вычитание векторов с созданием нового вектора:");
        Vector vector8 = Vector.getDifference(vector7, vector5);
        System.out.println(vector7 + " - " + vector5 + " = " + vector8);
        System.out.println();
        System.out.println("Скалярное произведение векторов:");
        System.out.println(vector4 + " x " + vector8 + " = " + Vector.getScalarProduct(vector4, vector8));
    }
}
