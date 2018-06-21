package com.epam.homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;

public class Matrix<E extends Number> {
    private final int rows;
    private final int columns;
    private Number[][] arr;

    private Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.arr = new Number[rows][columns];
    }

    private Matrix(int size) {
        this(size, size);
    }

    Matrix(Scanner scanner, Function<Scanner, E> parser) {
        this(scanner.nextInt());
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                arr[i][j] = parser.apply(scanner);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public E getElement(int row, int column){
        return (E) arr[row][column];
    }

    public void  setElement(E element, int columns, int rows){
        this.arr[columns][rows] = element;
    }
    
    void matrixSout(){
        System.out.println(columns);
        for (int i = 0; i < columns ; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(arr[i][j]+ " ");
            }
        }
    }

    void matrixRowsSort(Comparator<Number[]> comparator){
        Arrays.sort(arr, comparator);
    }
}
