package simple;

import utils.MyPrintFunction;

public class Transpose {
    public int[][] transpose(int[][] A) {
        int[][]res = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                res[j][i] = A[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                };
        MyPrintFunction.print(a);
        int [][]res=new Transpose().transpose(a);
        MyPrintFunction.print(res);
    }
}
