package com.epam.homework;

import java.text.DecimalFormat;
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
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double firstRoot = 0;
        double secondRoot = 0;
        String answer = "NO ROOTS";

        double discriminant = Math.pow(b, 2) - 4 * a * c;

        if (!(discriminant < 0)) {
            if (discriminant > 0) {
                firstRoot = (-b + Math.sqrt(discriminant)) / (2 * a);
                secondRoot = (-b - Math.sqrt(discriminant)) / (2 * a);
            }
            if (discriminant == 0) {
                firstRoot = (-b) / (2 * a);
                secondRoot = firstRoot;
            }
            answer = makeAnswer(firstRoot, secondRoot);
        }
        System.out.println(answer);
    }

    private static String makeAnswer(double firstRoot, double secondRoot) {
        DecimalFormat df = new DecimalFormat("#.##");

        if (firstRoot == secondRoot) {
            return df.format(firstRoot);
        } else {
            return df.format(firstRoot).concat(", ").concat(df.format(secondRoot));
        }
    }
}