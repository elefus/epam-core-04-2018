package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
     * -3.50, 0.00
     *
     *
     * ---------------------------------------------------------------------------------------------------
     * Входные данные:
     * 4 4 1
     *
     * Выходные данные:
     * -0.50
     *
     *
     * ---------------------------------------------------------------------------------------------------
     * Входные данные:
     * 7 0 35
     *
     * Выходные данные:
     * NO ROOTS
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] factors = reader.readLine().split(" ");
        int a = Integer.parseInt(factors[0]);
        int b = Integer.parseInt(factors[1]);
        int c = Integer.parseInt(factors[2]);

        double d = b*b - 4.0*a*c;

        double x1, x2;

        if (d > 0) {
            x1 = (-b + Math.sqrt(d)) / 2.0*a;
            x2 = (-b - Math.sqrt(d)) / 2.0*a;
            System.out.print(String.format(Locale.ENGLISH, "%.2f, %.2f%n", x1, x2));
        } else if (d == 0) {
            x1 = -b / (2.0*a);
            System.out.print(String.format(Locale.ENGLISH, "%.2f", x1));
        } else {
            System.out.println("NO ROOTS");
        }
    }
}
