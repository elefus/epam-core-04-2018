package com.epam.homework;

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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        double root1 = (-B - Math.sqrt(B * B - 4 * A * C)) / (2 * A);

        if (!Double.isFinite(root1)){
            System.out.println("NO ROOTS");
            return;
        }
        double root2 = (-B + Math.sqrt(B * B - 4 * A * C)) / (2 * A);

        String root1String = twoNumeralAfterComma(root1);

        if (root1 == root2){
            System.out.println(root1String);
            return;
        }
        String root2String = twoNumeralAfterComma(root2);

        System.out.println(root1String + ", " + root2String);
    }

    static String twoNumeralAfterComma(double root){

        root = Math.round(root * 100) / 100.0;
        String rootString = String.valueOf(root);
        int indexPoint = rootString.indexOf(".");

        if (rootString.length() < indexPoint + 3){
            rootString += 0;
        }
        return rootString;
    }
}
