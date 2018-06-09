package com.epam.homework;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Task9 {

    /**
     * С консоли вводятся три целых числа A, B, C.
     * Числа являются коэффициентами, задающими квадратное уравнение в общем виде: A*x^2 + B*x + C = 0
     * Необходимо найти корни этого уравнения.
     *
     * Формат входных данных:
     * Строка, содержащая 3 целых числа, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате решения уравнения может быть получено три варианта ответа:
     *
     * NO ROOTS
     * корень уравнения
     * первый корень уравнения, второй корень уравнения
     *
     * В результате выполнения в выходной поток посылается строка, соответствующая найденному решению.
     * Значения корней округляются до 2 знаков после запятой.
     * В качестве десятичного разделителя используется точка.
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 2 7 0
     *
     * Выходные данные:
     * -3.5, 0
     *
     *
     * ---------------------------------------------------------------------------------------------------
     * Входные данные:
     * 4 4 1
     *
     * Выходные данные:
     * -0.5
     *
     *
     * ---------------------------------------------------------------------------------------------------
     * Входные данные:
     * 7 0 35
     *
     * Выходные данные:
     * NO ROOTS
     */
    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat("#0.00");
//        formatter.setRoundingMode(RoundingMode.HALF_UP);
        try (Scanner reader = new Scanner(System.in)) {
            double a = reader.nextDouble();
            double b = reader.nextDouble();
            double c = reader.nextDouble();
            List<Double> roots = getRootsX2(a, b, c);
            if (roots == null)
                System.out.println("NO ROOTS");
            else {
                System.out.println(roots.stream().map(item ->{
                    item = round(item, 2);
                    if (item.equals(0.00) || item.equals(-0.00))
                        return "0.00";
                    return formatter.format(item).replace(',', '.');
                }).collect(Collectors.joining(", ")));
            }
        }
    }

    private static List<Double> getRootsX2(double a, double b, double c) {
        if (a == 0) {
            return getRootsX1(b, c);
        }

        double discriminant = getDiscriminant(a, b, c);
        if (discriminant > 0) {
            double x1, x2;
            x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
            if (!checkIfValidRoot(x1) || !checkIfValidRoot(x2))
                return null;
            return Arrays.asList(x1, x2);
        }
        else if (discriminant == 0) {
            double x;
            x = -b / (2 * a);
            return Arrays.asList(x);
        }
        return null;
    }

    private static List<Double> getRootsX1(double b, double c) {
        if (b != 0) {
            double x = -1.0 * c / b;
            return Arrays.asList(x);
        }
        return null;
    }

    private static double getDiscriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    private static boolean checkIfValidRoot(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d))
            return false;
        return true;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
