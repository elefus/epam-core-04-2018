package com.epam.homework;

import com.epam.homework.exceptions.IncompatibleDimensions;

import java.util.Scanner;

public class Matrix {
    private int vsize, hsize;
    private double M[][];

    public Matrix(int vsize, int hsize) {
        this.vsize = vsize;
        this.hsize = hsize;
        this.M = new double[vsize][hsize];

        for (int i = 0; i < this.vsize; i++) {
            for (int j = 0; j < this.hsize; j++) {
                this.M[i][j] = 0.0;
            }
        }
    }

    public Matrix(Matrix A) {
        vsize = A.getVsize();
        hsize = A.getHsize();
        this.M = new double[vsize][hsize];

        for (int i = 0; i < this.vsize; i++) {
            for (int j = 0; j < this.hsize; j++) {
                this.M[i][j] = A.getElement(i, j);
            }
        }
    }

    public Matrix(Scanner in) {
        this.hsize = this.vsize = Integer.parseInt(in.next());
        this.M = new double[this.vsize][this.hsize];
        for (int row = 0; row < this.vsize; row++) {
            for (int col = 0; col < this.hsize; col++) {
                this.M[row][col] = Double.parseDouble(in.next());
            }
        }
    }

    public Matrix(int N) {
        this.vsize = N;
        this.hsize = N;
        this.M = new double[vsize][hsize];

        for (int i = 0; i < this.vsize; i++) {
            for (int j = 0; j < this.hsize; j++) {
                this.M[i][j] = 0.0;
            }
        }
    }

    public void Add(int i, int j, double value) {
        if (i <= vsize && j <= hsize) {
            this.M[i][j] = value;
        } else {
            throw new IncompatibleDimensions();
        }

    }

    public int getVsize() {
        return this.vsize;
    }

    public int getHsize() {
        return this.hsize;
    }

    public double getElement(int i, int j) {
        return this.M[i][j];
    }

    public void SwapRows(int a, int b) {
        if (a == b) return;
        double[] tmp = M[a];
        M[a] = M[b];
        M[b] = tmp;
        return;
    }

    public void SwapColumns(int a, int b) {
        if (a == b) {
            return;
        }
        int N = this.vsize;
        if (a > N || b > N) {
            throw new IncompatibleDimensions();
        }
        double tmp;
        for (int i = 0; i < N; ++i) {
            tmp = M[i][a];
            M[i][a] = M[i][b];
            M[i][b] = tmp;
        }
    }

    public void clear() {
        for (int i = 0; i < vsize; i++)
            for (int j = 0; j < hsize; j++)
                M[i][j] = 0.0;
    }

    public void insertDiag(double A) {
        for (int i = 0; i < vsize; ++i)
            for (int j = 0; j < hsize; ++j) {
                if (i == j) M[i][j] = A;
            }
    }

    public double norm() {
        int n = vsize;
        int m = hsize;
        double max = 0;
        for (int i = 0; i < n; ++i) {
            double tmp = 0;
            for (int j = 0; j < m; ++j)
                tmp += Math.abs(M[i][j]);
            if (tmp > max) max = tmp;
        }
        return max;
    }


    public void diagonalize() {
        for (int i = 0; i < vsize; i++) {
            double tmp = 0.0;
            for (int j = 0; j < hsize; j++)
                tmp += Math.abs(this.getElement(i, j));
            if (this.getElement(i, i) < 0) this.Add(i, i, -tmp);
            else this.Add(i, i, tmp);
        }
    }


    public static Matrix transpose(Matrix M) {
        int n = M.getVsize();
        int m = M.getHsize();
        Matrix A = new Matrix(m, n);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                A.Add(j, i, M.getElement(i, j));
        return A;
    }

    public static Matrix sum(Matrix A, Matrix B) {
        if (A.getHsize() != B.getHsize() || A.getVsize() != B.getVsize()) {
            throw new IncompatibleDimensions();
        }
        int hsize = A.getHsize();
        int vsize = A.getVsize();
        Matrix C = new Matrix(vsize, hsize);
        for (int i = 0; i < vsize; i++) {
            for (int j = 0; j < hsize; j++) {
                C.Add(i, j, A.getElement(i, j) + B.getElement(i, j));
            }
        }
        return C;
    }

    public static Matrix subtract(Matrix A, Matrix B) {
        if (A.getHsize() != B.getHsize() || A.getVsize() != B.getVsize()) {
            throw new IncompatibleDimensions();
        }
        int hsize = A.getHsize();
        int vsize = A.getVsize();
        Matrix C = new Matrix(vsize, hsize);
        for (int i = 0; i < vsize; i++) {
            for (int j = 0; j < hsize; j++) {
                C.Add(i, j, A.getElement(i, j) - B.getElement(i, j));
            }
        }
        return C;
    }

    public static Matrix multiply(Matrix A, Matrix B) {
        if (A.getHsize() != B.getVsize()) {
            throw new IncompatibleDimensions();
        }
        int vsize = A.getHsize();
        int hsize = B.getVsize();
        Matrix C = new Matrix(vsize, hsize);
        for (int i = 0; i < A.getVsize(); ++i) {
            for (int j = 0; j < B.getHsize(); ++j) {
                for (int k = 0; k < A.getHsize(); ++k) {
                    C.Add(i, j, C.getElement(i, j) + A.getElement(i, k) * B.getElement(k, j));
                }
            }
        }
        return C;
    }

    @Override
    public String toString() {
        String result = "Matrix{"+System.lineSeparator();
        for (int i = 0; i < vsize; i++) {
            for (int j = 0; j < hsize; j++) {
                result+=this.getElement(i,j)+" ";
            }
            result+=System.lineSeparator();
        }
        return result;
    }
}


