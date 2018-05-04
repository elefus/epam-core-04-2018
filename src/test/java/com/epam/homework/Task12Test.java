package com.epam.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task12Test {
    @Test
    @DisplayName("Task12.sortMatrix method should sort a matrix properly")
    void test1() {
        int [][] matrix = new int[][] {
                {0,    2,    3,    4,    5},
                {1,    3,    0,    2,   -1},
                {7,   -1,   -5,    5,    0},
                {5,    4,   -4,   -2,    2},
                {1,    3,   -3,   -4,    3}
        };
        int sortColumnIndex = 2;
        int[][] expected = new int[][] {
                {7,   -1,   -5,    5,    0},
                {5,    4,   -4,   -2,    2},
                {1,    3,   -3,   -4,    3},
                {1,    3,    0,    2,   -1},
                {0,    2,    3,    4,    5}
        };

        assertArrayEquals(Task12.sortMatrix(matrix, sortColumnIndex), expected);
    }

    @Test
    @DisplayName("Task12.getMatrixColumn method should return a proper matrix column")
    void test2() {
        int [][] matrix = new int[][] {
                {0,    2,    3,    4,    5},
                {1,    3,    0,    2,   -1},
                {7,   -1,   -5,    5,    0},
                {5,    4,   -4,   -2,    2},
                {1,    3,   -3,   -4,    3}
        };
        int columnIndex = 2;
        int[] expected = new int[] {3, 0, -5, -4, -3};

        assertArrayEquals(Task12.getMatrixColumn(matrix, columnIndex), expected);
    }

    @Test
    @DisplayName("Task12.swapMatrixLines method should swap corresponding matrix lines")
    void test3() {
        int [][] matrix = new int[][] {
                {0,    2,    3,    4,    5},
                {1,    3,    0,    2,   -1},
                {7,   -1,   -5,    5,    0},
                {5,    4,   -4,   -2,    2},
                {1,    3,   -3,   -4,    3}
        };
        int i = 0;
        int j = 1;
        int [][] expected = new int[][] {
                {1,    3,    0,    2,   -1},
                {0,    2,    3,    4,    5},
                {7,   -1,   -5,    5,    0},
                {5,    4,   -4,   -2,    2},
                {1,    3,   -3,   -4,    3}
        };

        Task12.swapMatrixLines(matrix, i, j);

        assertArrayEquals(matrix, expected);
    }
}
