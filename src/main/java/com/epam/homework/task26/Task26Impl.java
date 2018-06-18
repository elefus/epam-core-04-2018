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
        Task26.I2DPoint expectedPoint = new Point(4, 2);
        Line line1 = Line.getLineFromSegment(new Segment(new Point(-2, -1), new Point(2, 1)));
        Line line2 = Line.getLineFromSegment(new Segment(new Point(3, 3), new Point(1, 5)));
        Task26.I2DPoint actualPoint = line1.getIntersectionPoint(line2);
        System.out.println(actualPoint);
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

    public Matrix(Line line1, Line line2) {
        data = new double[][]{
                {line1.getA(), line1.getB()},
                {line2.getA(), line2.getB()}
        };
        rowsCount = data.length;
        columnsCount = data[0].length;
    }

    public double[][] getData() {
        return data;
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

    public static double getDeterminant(double[][] matrix) {

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
 * Линия вида Ax + By + C = 0
 */
class Line {

    private double a;
    private double b;
    private double c;

    public Line(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public String toString() {
        return "Line{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    /**
     * Возвращает уравнение прямой, на которой лежит отрезок.
     */
    public static Line getLineFromSegment(Task26.ISegment segment) {

        double a = segment.first().getY() - segment.second().getY(); // y1 - y2
        double b = segment.second().getX() - segment.first().getX(); // x2 - x1
        double c = segment.first().getX() * segment.second().getY()
                - segment.second().getX() * segment.first().getY(); // x1y2 - x2y1

        return new Line(a, b, c);
    }

    Task26.I2DPoint getIntersectionPoint(Line otherLine) {

        double det = Matrix.getDeterminant(new Matrix(this, otherLine).getData());
        double detX = Matrix.getDeterminant(new Matrix(this, otherLine).replaceColumn(0, new double[]{-c, -otherLine.getC()}).getData());
        double detY = Matrix.getDeterminant(new Matrix(this, otherLine).replaceColumn(1, new double[]{-c, -otherLine.getC()}).getData());

        Task26.I2DPoint point = new Point(detX / det, detY / det);

        return point;
    }
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
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
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