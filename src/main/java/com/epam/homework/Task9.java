package com.epam.homework;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Task9 {

    /**
     * С консоли вводятся три целых числа A, B, C.
     * Числа являются коэффициентами, задающими квадратное уравнение в общем виде: A*x^2  B*x  C = 0
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
     * -3.50, 0.00
     * <p>
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Входные данные:
     * 4 4 1
     * <p>
     * Выходные данные:
     * -0.50
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
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        if (a == 0) {
            System.out.printf(decimalFormat.format(-c / b));
            return;
        }

        int discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {

            double x1 = (-b - Math.sqrt(discriminant)) / 2 / a;
            double x2 = (-b + Math.sqrt(discriminant)) / 2 / a;

            System.out.printf(decimalFormat.format(x1) + ", " + decimalFormat.format(x2));

        } else if (discriminant == 0) {
            double x = (-b - Math.sqrt(discriminant)) / 2 / a;
            System.out.println(decimalFormat.format(x));

        } else {
            System.out.println("NO ROOTS");
        }
    }

}
