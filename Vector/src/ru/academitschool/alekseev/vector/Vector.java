package ru.academitschool.alekseev.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность <= 0. Полученное значение: " + n);
        }

        components = new double[n];
    }

    public Vector(Vector vector) {
        this.components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] array) {
        if (array.length <= 0) {
            throw new IllegalArgumentException("Размерность <= 0. Полученное значение: " + array.length);
        }

        components = Arrays.copyOf(array, array.length);
    }


    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность <= 0. Полученное значение: " + n);
        }

        components = Arrays.copyOf(array, n);
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");

        for (double element : components) {
            stringBuilder.append(element).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append("}");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Vector vector = (Vector) o;
        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(components);
        return hash;
    }

    public Vector add(Vector vector) {
        if (vector.components.length > this.components.length) {
            this.components = Arrays.copyOf(this.components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            this.components[i] += vector.components[i];
        }

        return this;
    }

    public Vector subtract(Vector vector) {
        if (vector.components.length > this.components.length) {
            this.components = Arrays.copyOf(this.components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            this.components[i] -= vector.components[i];
        }

        return this;
    }

    public Vector multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }

        return this;
    }

    public Vector reverse() {
        multiplyByScalar(-1);
        return this;
    }

    public double getComponent(int index) {
        if (index >= components.length || index < 0) {
            throw new IllegalArgumentException("несуществующий индекс");
        }

        return components[index];
    }

    public void setComponent(int index, double component) {
        if (index < 0 || index >= components.length) {
            throw new IllegalArgumentException("несуществующий индекс");
        }

        this.components[index] = component;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1);
        resultVector.add(vector2);
        return resultVector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1);
        resultVector.subtract(vector2);
        return resultVector;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;
        int minSize = Math.min(vector1.components.length, vector2.components.length);

        for (int i = 0; i < minSize; i++) {
            scalarProduct += (vector1.components[i] * vector2.components[i]);
        }

        return scalarProduct;
    }
}
