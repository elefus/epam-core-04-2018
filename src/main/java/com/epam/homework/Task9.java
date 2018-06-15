package com.epam.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
        try (Scanner reader = new Scanner(System.in)) {
            int a = reader.nextInt();
            int b = reader.nextInt();
            int c = reader.nextInt();

            List<Double> roots =  calcRoots(a, b, c);

            if (roots.isEmpty()) {
                System.out.println("NO ROOTS");
            } else {
                System.out.println(roots
                        .stream()
                        .map(root -> String.format("%.2f", root))
                        .collect(Collectors.joining(", "))
                );
            }
        }
    }

    private static List<Double> calcRoots(int a, int b, int c) {
        List<Double> roots = new ArrayList<>();
        double D = calcDiscriminant(a, b, c);

        if (D > 0) {
            roots.add((-b + Math.sqrt(D)) / (2.0 * a));
            roots.add((-b - Math.sqrt(D)) / (2.0 * a));
        } else if (D == 0) {
            roots.add(-b / (2.0 * a));
        }

        return roots;
    }

    private static double calcDiscriminant(int a, int b, int c) {
        return b * b - 4.0 * a * c;
    }
}
