package com.epam.homework;

import java.text.DecimalFormat;
import java.util.Scanner;

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

    public static final DecimalFormat outputFormat = new DecimalFormat("#0.00");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();

        double discriminant = Math.pow(b, 2) - 4 * a * c;

        if (discriminant < 0) {
            System.out.print("NO ROOTS");
        } else if (discriminant == 0) {
            System.out.print(outputFormat.format(-b / (2 * a)));
        } else {
            System.out.print(outputFormat.format ((-b - Math.sqrt(discriminant)) / (2 * a)));
            System.out.print(", ");
            System.out.print(outputFormat.format ((-b + Math.sqrt(discriminant)) / (2 * a)));
        }
    }
}
