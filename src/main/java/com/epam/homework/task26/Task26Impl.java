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
        TreeSet<Point> intersectionPoints = new TreeSet<>();

        for (int i = 0; i < segmentsList.size(); i++) {

            Segment segment = (Segment) segmentsList.get(i);

            for (int j = i + 1; j < segmentsList.size(); j++) {

                Segment currentSegment = (Segment) segmentsList.get(j);
                I2DPoint point = segment.getIntersectionPoint(currentSegment);

                if (point != null) {
                    intersectionPoints.add((Point) point);
                }
            }
        }

        Set<I2DPoint> result = new HashSet<>();
        I2DPoint pointWithMinX = intersectionPoints.first();
        for (I2DPoint point : intersectionPoints) {
            if (point.getX() == pointWithMinX.getX()) {
                result.add(point);
            } else {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Set<ISegment> segments = new HashSet<>();

        segments.add(new Segment(new Point(1, 2), new Point(3, 4)));
        segments.add(new Segment(new Point(5, 1), new Point(7, 1)));
        segments.add(new Segment(new Point(0, 4), new Point(4, 2)));
        segments.add(new Segment(new Point(5, 3), new Point(3, 2)));
        segments.add(new Segment(new Point(4, 5), new Point(5, 3)));
        segments.add(new Segment(new Point(6, 3), new Point(6, 1)));
        segments.add(new Segment(new Point(8, 4), new Point(7, 2)));
        segments.add(new Segment(new Point(2, 0), new Point(2, 6)));
        segments.add(new Segment(new Point(0, 5), new Point(3, 5)));

        System.out.println(new Task26Impl().analyze(segments));
    }
}

/**
 * Точка на двумерной плоскости.
 */
class Point implements Task26.I2DPoint, Comparable {

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
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Point otherPoint = (Point) o;

        int result = Double.compare(x, otherPoint.x);
        if (result != 0) {
            return result;
        }

        result = Double.compare(y, otherPoint.y);
        return result;
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

    /**
     * Поиск точки пересечения прямых путём решения системы из двух линейних уравнений методом Крамера.
     *
     * @param otherLine
     * @return
     */
    Task26.I2DPoint getIntersectionPoint(Line otherLine) {

        Matrix mainMatrix = new Matrix(this, otherLine);
        Matrix matrixX = mainMatrix.replaceColumn(0, new double[]{-c, -otherLine.c});
        Matrix matrixY = mainMatrix.replaceColumn(1, new double[]{-c, -otherLine.c});

        double det = Matrix.getDeterminant(mainMatrix.getData());

        if (det == 0) {
            return null;
        }

        double detX = Matrix.getDeterminant(matrixX.getData());
        double detY = Matrix.getDeterminant(matrixY.getData());

        return new Point(detX / det, detY / det);
    }
}

/**
 * Отрезок.
 */
class Segment extends Line implements Task26.ISegment {

    private TreeSet<Point> points = new TreeSet<>();

    public Segment(Point firstPoint, Point secondPoint) {
        super(
                firstPoint.getY() - secondPoint.getY(), // y1 - y2
                secondPoint.getX() - firstPoint.getX(), // x2 - x1
                firstPoint.getX() * secondPoint.getY() - secondPoint.getX() * firstPoint.getY() // x1y2 - x2y1
        );
        points.add(firstPoint);
        points.add(secondPoint);
    }

    @Override
    public Task26.I2DPoint first() {
        return points.first();
    }

    @Override
    public Task26.I2DPoint second() {
        return points.last();
    }

    private Task26.I2DPoint getPointWithMinY() {
        return first().getY() <= second().getY() ? first() : second();
    }

    private Task26.I2DPoint getPointWithMaxY() {
        return first().getY() >= second().getY() ? first() : second();
    }

    private boolean mayContainPoint(Task26.I2DPoint point) {
        return point.getX() >= first().getX()
                && point.getX() <= second().getX()
                && point.getY() >= getPointWithMinY().getY()
                && point.getY() <= getPointWithMaxY().getY();
    }

    public Task26.I2DPoint getIntersectionPoint(Segment otherSegment) {
        Task26.I2DPoint intersectionOfLines = super.getIntersectionPoint(otherSegment);

        if (intersectionOfLines != null
                && mayContainPoint(intersectionOfLines)
                && otherSegment.mayContainPoint(intersectionOfLines)) {
            return intersectionOfLines;
        }

        return null;
    }
}

/**
 * Матрица
 */
class Matrix {

    private int rowsCount;
    private int columnsCount;
    private double[][] data;

    public Matrix(double[][] data) {
        this.data = data;
        rowsCount = data.length;
        columnsCount = data[0].length;
    }

    /**
     * Матрица из коэффициентов A и B прямых вида Ax + By + C = 0
     * @param line1
     * @param line2
     */
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

                int iInMatrix = (i >= rowToRemove) ? i + 1 : i;
                int jInMatrix = (j >= columnToRemove) ? j + 1 : j;

                minor[i][j] = matrix[iInMatrix][jInMatrix];
            }
        }

        return minor;
    }
}