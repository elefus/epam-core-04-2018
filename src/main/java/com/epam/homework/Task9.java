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
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double a = Double.parseDouble(in.next());
        double b = Double.parseDouble(in.next());
        double c = Double.parseDouble(in.next());

        Set<Double> roots = getRootsOfEquation(a, b, c);
        printRoots(roots);


    }

    private static void printRoots(Set<Double> roots) {

        DecimalFormatSymbols s = new DecimalFormatSymbols();
        s.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        StringBuilder result = new StringBuilder("");
        Iterator<Double> iterator = roots.iterator();

        if (roots.isEmpty()) {
            result.append("NO ROOTS");
        } else if (roots.size() == 1) {
            result.append(df.format(iterator.next()));
        } else if (roots.size() == 2) {
            result.append(df.format(iterator.next())).append(", ");
            result.append(df.format(iterator.next()));
        }



        System.out.println(result);
    }

    private static Set<Double> getRootsOfEquation(double a, double b, double c) {
        Set<Double> roots = new LinkedHashSet<>();

        double discriminant = Math.pow(b, 2) - 4 * a * c;

        double x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
        double x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
        roots.addAll(Arrays.asList(x1, x2));

        return roots;
    }
}
