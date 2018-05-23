package com.epam.homework;

import com.epam.homework.exceptions.NotSquareMatrix;

public class PLUDecomposition {
    public static Solution PLUC(Matrix M) {
        int swaps = 0;
        int n = M.getVsize();
        int m = M.getHsize();
        int rank = n;
        Matrix A = new Matrix(M);
        Matrix P = new Matrix(M.getVsize(), M.getHsize());
        Matrix Q = new Matrix(M.getVsize(), M.getHsize());
        Matrix L = new Matrix(M.getVsize(), M.getHsize());
        Matrix U = new Matrix(M.getVsize(), M.getHsize());

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (i == j) {
                    P.Add(i, j, 1);
                    Q.Add(i, j, 1);
                } else {
                    P.Add(i, j, 0);
                    Q.Add(i, j, 0);
                }

        for (int i = 0; i < n; ++i) {
            double max = Math.abs(A.getElement(i, i));
            int max_row = i, max_col = i;
            for (int j = i; j < n; ++j)
                for (int k = i; k < n; ++k)
                    if (Math.abs(A.getElement(j, k)) > max) {
                        max = Math.abs(A.getElement(j, k));
                        max_row = j;
                        max_col = k;
                    }
            if (Math.abs(max) < Math.pow(10, -15)) {
                --rank;
                continue;
            }

            if (i != max_row) {
                A.SwapRows(i, max_row);
                P.SwapRows(i, max_row);
                swaps++;
            }

            if (i != max_col) {
                A.SwapColumns(i, max_col);
                Q.SwapColumns(i, max_col);
                swaps++;
            }

            for (int j = i + 1; j < n; ++j) {
                A.Add(j, i, A.getElement(j, i) / A.getElement(i, i));
            }

            for (int j = i + 1; j < n; ++j) {
                for (int k = i + 1; k < n; ++k) {
                    A.Add(j, k, A.getElement(j, k) - A.getElement(j, i) * A.getElement(i, k));
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (i == j) {
                    L.Add(j, i, 1);
                } else {
                    L.Add(j, i, A.getElement(j, i));
                }
                U.Add(i, j, A.getElement(i, j));
            }
        }
        return new Solution(P, Q, L, U, rank, swaps);
    }

    public static double det(Solution solution) {
        double det = 1;
        Matrix U = solution.getU();
        if (U.getVsize() != U.getHsize()) {
            throw new NotSquareMatrix();
        }
        int N = U.getVsize();
        for (int i = 0; i < N; i++) {
            det *= U.getElement(i, i);
        }

        if (solution.getSwaps() % 2 == 0)
            return det;
        else
            return -det;
    }
}
