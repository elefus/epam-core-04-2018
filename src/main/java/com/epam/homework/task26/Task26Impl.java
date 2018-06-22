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

        // Все точки пересечения отрезков, упорядоченные по возрастанию значения абсциссы
        TreeSet<I2DPoint> intersectionPoints = new TreeSet<>((o1, o2) -> {
            int result = Double.compare(o1.getX(), o2.getX());
            if (result != 0) {
                return result;
            }
            result = Double.compare(o1.getY(), o2.getY());
            return result;
        });

        for (int i = 0; i < segmentsList.size(); i++) {

            ISegment segment1 = segmentsList.get(i);

            for (int j = i + 1; j < segmentsList.size(); j++) {

                ISegment segment2 = segmentsList.get(j);
                I2DPoint point = getIntersectionPoint(segment1, segment2);

                if (point != null) {
                    intersectionPoints.add(point);
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

    private I2DPoint getPointOfSegmentWithMinX(ISegment segment) {
        return segment.first().getX() <= segment.second().getX() ? segment.first() : segment.second();
    }

    private I2DPoint getPointOfSegmentWithMaxX(ISegment segment) {
        return segment.first().getX() >= segment.second().getX() ? segment.first() : segment.second();
    }

    private I2DPoint getPointOfSegmentWithMinY(ISegment segment) {
        return segment.first().getY() <= segment.second().getY() ? segment.first() : segment.second();
    }

    private I2DPoint getPointOfSegmentWithMaxY(ISegment segment) {
        return segment.first().getY() >= segment.second().getY() ? segment.first() : segment.second();
    }

    private boolean maySegmentContainPoint(ISegment segment, I2DPoint point) {
        return point.getX() >= getPointOfSegmentWithMinX(segment).getX()
                && point.getX() <= getPointOfSegmentWithMaxX(segment).getX()
                && point.getY() >= getPointOfSegmentWithMinY(segment).getY()
                && point.getY() <= getPointOfSegmentWithMaxY(segment).getY();
    }

    public I2DPoint getIntersectionPoint(ISegment segment1, ISegment segment2) {

        I2DPoint intersectionOfLines = Line.getLineFromSegment(segment1)
                .getIntersectionPoint(Line.getLineFromSegment(segment2));

        if (intersectionOfLines != null
                && maySegmentContainPoint(segment1, intersectionOfLines)
                && maySegmentContainPoint(segment2, intersectionOfLines)) {
            return intersectionOfLines;
        }

        return null;
    }

    /**
     * Точка на двумерной плоскости.
     */
    static class Point implements I2DPoint {

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
    static class Line {

        private double a;
        private double b;
        private double c;

        public Line(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public static Line getLineFromSegment(ISegment segment) {
            double a = segment.first().getY() - segment.second().getY(); // y1 - y2
            double b = segment.second().getX() - segment.first().getX(); // x2 - x1
            double c = segment.first().getX() * segment.second().getY()
                    - segment.second().getX() * segment.first().getY(); // x1y2 - x2y1
            return new Line(a, b, c);
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
        I2DPoint getIntersectionPoint(Line otherLine) {

            Matrix mainMatrix = new Matrix(this, otherLine);
            Matrix matrixX = mainMatrix.replaceColumn(0, new double[]{-c, -otherLine.c});
            Matrix matrixY = mainMatrix.replaceColumn(1, new double[]{-c, -otherLine.c});

            double det = Matrix.getDeterminant(mainMatrix.getData());

            if (det == 0) {
                return null;
            }

            double detX = Matrix.getDeterminant(matrixX.getData());
            double detY = Matrix.getDeterminant(matrixY.getData());

            return new Point(detX / det + 0, detY / det + 0);
        }
    }

    /**
     * Отрезок.
     */
    static class Segment implements ISegment {

        private I2DPoint firstPoint;
        private I2DPoint secondPoint;

        public Segment(I2DPoint firstPoint, I2DPoint secondPoint) {
            this.firstPoint = firstPoint;
            this.secondPoint = secondPoint;
        }

        @Override
        public I2DPoint first() {
            return firstPoint;
        }

        @Override
        public I2DPoint second() {
            return secondPoint;
        }
    }

    /**
     * Матрица
     */
    static class Matrix {

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
                sum += sign * matrix[0][j] * getDeterminant(getMinor(matrix, j));
            }

            return sum;
        }

        private static double[][] getMinor(double[][] matrix, int columnToRemove) {

            double[][] minor = new double[matrix.length - 1][matrix.length - 1];

            for (int i = 0; i < minor.length; i++) {
                for (int j = 0; j < minor.length; j++) {

                    int iInMatrix = i + 1;
                    int jInMatrix = (j >= columnToRemove) ? j + 1 : j;

                    minor[i][j] = matrix[iInMatrix][jInMatrix];
                }
            }

            return minor;
        }
    }
}