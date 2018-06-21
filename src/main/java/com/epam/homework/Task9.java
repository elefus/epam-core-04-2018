package com.epam.homework;

import java.util.Locale;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        findSolution(a, b, c);
    }

    private static void findSolution(int a, int b, int c) {
        double discriminant = Math.pow(b, 2) - 4 * a * c;
        if (discriminant < 0) {
            System.out.println("NO ROOTS");
            return;
        }
        if (discriminant == 0) {
            System.out.println(String.format(Locale.ENGLISH,"%.2f", Math.round((-b) / (2.0 * a) * 100) / 100.0));
        } else {
            System.out.print(String.format(Locale.ENGLISH,"%.2f", Math.round((-b - Math.sqrt(discriminant)) / (2.0 * a) * 100) / 100.0) + ", ");
            System.out.println(String.format(Locale.ENGLISH,"%.2f", Math.round((-b + Math.sqrt(discriminant)) / (2.0 * a) * 100) / 100.0));
        }
    }
}
