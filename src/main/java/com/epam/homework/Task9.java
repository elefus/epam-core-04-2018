package com.epam.homework;

import java.util.*;
import java.util.stream.Stream;

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
        Scanner in = new Scanner(System.in);

        double a = Double.parseDouble(in.next());
        double b = Double.parseDouble(in.next());
        double c = Double.parseDouble(in.next());
//joiner
        Set<Double> result = getRootsOfEquation(a, b, c);

        for (Double root : result) {
            System.out.println(root);
        }


    }

    private static Set<Double> getRootsOfEquation(double a, double b, double c){
        Set<Double> roots = new HashSet<>();

        double discriminant = Math.pow(b, 2) - 4 * a * c;

        double x1 = (- b + Math.sqrt(discriminant)) / (2*a);
        double x2 = (- b - Math.sqrt(discriminant)) / (2*a);
        roots.addAll(Arrays.asList(x1, x2));

        return roots;
    }
}
