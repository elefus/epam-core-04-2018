package main.java.com.epam.homework;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

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
    public static void main(String[] args) throws IOException {
        // TODO реализация
        Scanner in = new Scanner(System.in);

        double A = in.nextDouble();
        double B = in.nextDouble();
        double C = in.nextDouble();
        double D = B * B - 4 * A * C;
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");

        if (D < 0) {
            System.out.println("NO ROOTS");
        }
        if (D == 0) {
            System.out.println(decimalFormat.format(-B / (2 * A)));
        }
        if (D > 0) {
            System.out.print(decimalFormat.format((-B-Math.sqrt(D)) / (2 * A)));
            System.out.print(", ");
            System.out.print(decimalFormat.format((-B+Math.sqrt(D)) / (2 * A)));
        }
    }
}
