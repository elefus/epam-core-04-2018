package com.epam.homework.task26;

import java.util.*;

public class Task26Impl implements Task26 {

    /**
     * На плоскости задано N отрезков (2 <= N <= 20).
     * Найти точку (возможно несколько) пересечения двух отрезков, имеющую минимальную абсциссу.
     * Использовать класс TreeMap.
     *
     * @param segments Множество отрезков.
     * @return Множество точек пересечения, имеющих минимальную абсциссу.
     */
    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {

        List<ISegment> segmentsList = new ArrayList<>(segments);

        for (int i = 0; i < segmentsList.size(); i++) {
            for (int j = i + 1; j < segmentsList.size(); j++) {

            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}

class Matrix {

    private int rowsCount;
    private int columnsCount;
    private double[][] data;

    public Matrix(double[][] data) {
        this.data = data;
        rowsCount = data.length;
        columnsCount = data[0].length;
    }

    public Matrix replaceColumn(int index, double[] newColumn) {

        double[][] newData = new double[rowsCount][columnsCount];
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                newData[i][j] = j == index ? newColumn[i] : data[i][j];
            }
        }
        return new Matrix(newData);
    }

    private static double getDeterminant(double[][] matrix) {

        if (matrix.length == 1) {
            return matrix[0][0];
        }

        int sum = 0;

        for (int j = 0; j < matrix.length; j++) {

            int sign = (j % 2 == 0) ? 1 : -1;
            sum += sign * matrix[0][j] * getDeterminant(getMinor(matrix, 0, j));
        }

        return sum;
    }

    private static double[][] getMinor(double[][] matrix, int rowToRemove, int columnToRemove) {

        double[][] minor = new double[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < minor.length; i++) {
            for (int j = 0; j < minor.length; j++) {

                // Indices for Matrix
                int iInMatrix = (i >= rowToRemove) ? i + 1 : i;
                int jInMatrix = (j >= columnToRemove) ? j + 1 : j;

                minor[i][j] = matrix[iInMatrix][jInMatrix];
            }
        }

        return minor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix = (Matrix) o;

        if (rowsCount != matrix.rowsCount) return false;
        if (columnsCount != matrix.columnsCount) return false;
        return Arrays.deepEquals(data, matrix.data);
    }

    @Override
    public int hashCode() {
        int result = rowsCount;
        result = 31 * result + columnsCount;
        result = 31 * result + Arrays.deepHashCode(data);
        return result;
    }
}

/**
 * Линия вида kx + y = b
 */
class Line {

    private double k;
    private double b;

    public Line(double k, double b) {
        this.k = k;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Line{" +
                "k=" + k +
                ", b=" + b +
                '}';
    }

    /**
     * Возвращает уравнение прямой, на которой лежит отрезок.
     */
    public static Line getLineFromSegment(Task26.ISegment segment) {

        // Коэффициенты для уравнения прямой вида Ax + By + C = 0
        double coeffA = segment.second().getY() - segment.first().getY();
        double coeffB = segment.second().getX() - segment.first().getX();
        double coeffC = segment.second().getX() * segment.first().getY() - segment.first().getX() * segment.second().getY();

        // Коэффициенты для уравнения прямой вида y = kx + b
        double k = coeffA / coeffB;
        double b = coeffC / coeffB;

        return new Line(k, b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (Double.compare(line.k, k) != 0) return false;
        return Double.compare(line.b, b) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(k);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(b);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
/*
    Task26.I2DPoint getIntersectionPoint(Line otherLine) {

    }*/
}

/**
 * Отрезок.
 */
class Segment implements Task26.ISegment {

    private Point first;
    private Point second;

    public Segment(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Task26.I2DPoint first() {
        return first;
    }

    @Override
    public Task26.I2DPoint second() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Segment segment = (Segment) o;

        if (first != null ? !first.equals(segment.first) : segment.first != null) return false;
        return second != null ? second.equals(segment.second) : segment.second == null;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}

/**
 * Точка на двумерной плоскости.
 */
class Point implements Task26.I2DPoint {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (Double.compare(point.x, x) != 0) return false;
        return Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}