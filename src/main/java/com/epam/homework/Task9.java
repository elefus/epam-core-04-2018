package com.epam.homework;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.stream.Stream;

public class Task9 {

    /**
     * С консоли вводятся три целых числа A, B, C.
     * Числа являются коэффициентами, задающими квадратное уравнение в общем виде: A*x^2 + B*x + C = 0
     * Необходимо найти корни этого уравнения.
     * <p>
     * Формат входных данных:
     * Строка, содержащая 3 целых числа, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате решения уравнения может быть получено три варианта ответа:
     * <p>
     * NO ROOTS
     * корень уравнения
     * первый корень уравнения, второй корень уравнения
     * <p>
     * В результате выполнения в выходной поток посылается строка, соответствующая найденному решению.
     * Значения корней округляются до 2 знаков после запятой.
     * В качестве десятичного разделителя используется точка.
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 2 7 0
     * <p>
     * Выходные данные:
     * -3.5, 0
     * <p>
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Входные данные:
     * 4 4 1
     * <p>
     * Выходные данные:
     * -0.5
     * <p>
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Входные данные:
     * 7 0 35
     * <p>
     * Выходные данные:
     * NO ROOTS
     */
    private static final double eps = 0.0000001;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double a = Double.parseDouble(in.next());
        double b = Double.parseDouble(in.next());
        double c = Double.parseDouble(in.next());

        List<Double> roots = getRootsOfEquation(a, b, c);
        printRoots(roots);
    }

    private static void printRoots(List<Double> roots) {

        DecimalFormat outFormat = new DecimalFormat("#0.00");
        StringBuilder result = new StringBuilder("");
        Iterator<Double> iterator = roots.iterator();

        if (roots.isEmpty()) {
            result.append("NO ROOTS");
        } else if (roots.size() == 1) {
            result.append(outFormat.format(iterator.next()));
        } else if (roots.size() == 2) {
            result.append(outFormat.format(iterator.next())).append(", ");
            result.append(outFormat.format(iterator.next()));
        }

        System.out.println(result);
    }

    private static List<Double> getRootsOfEquation(double a, double b, double c) {
        List<Double> roots = new LinkedList<>();

        double discriminant = Math.pow(b, 2) - 4 * a * c;

        if (Math.abs(a - 0) < eps) {
            roots.add(-c / b);
            return roots;
        } else if (Math.abs(discriminant - 0) < eps) {
            roots.add((-b) / (2 * a));
            return roots;
        } else if (discriminant > 0) {
            double x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
            roots.addAll(Arrays.asList(x1, x2));
            return roots;
        }

        return roots;
    }
}
