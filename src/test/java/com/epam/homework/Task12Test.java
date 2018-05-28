//package com.epam.homework;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class Task12Test {
//    @Test
//    @DisplayName("Task12.sortMatrix method should sort a matrix properly")
//    void test1() {
//        int [][] matrix = new int[][] {
//                {0,    2,    3,    4,    5},
//                {1,    3,    0,    2,   -1},
//                {7,   -1,   -5,    5,    0},
//                {5,    4,   -4,   -2,    2},
//                {1,    3,   -3,   -4,    3}
//        };
//        int sortColumnIndex = 2;
//        int[][] expected = new int[][] {
//                {7,   -1,   -5,    5,    0},
//                {5,    4,   -4,   -2,    2},
//                {1,    3,   -3,   -4,    3},
//                {1,    3,    0,    2,   -1},
//                {0,    2,    3,    4,    5}
//        };
//
//        assertArrayEquals(Task12.sortMatrix(matrix, sortColumnIndex), expected);
//    }
//}
