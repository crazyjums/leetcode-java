package middle;

import utils.MyPrintFunction;

public class Rotate {
    public void rotate(int[][] matrix) {
        int[][] temp = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            temp[i] = matrix[i].clone();
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int k = 0;
        for (int i = col - 1; i >= 0; i--) {
            for (int j = 0; j < row; j++) {
                matrix[j][i] = temp[k][j];
            }
            k++;
        }
    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        /**
         * 1.先将数组的左下角和右上角的元素交换，得到如下：
         * 1 4 7
         * 2 5 8
         * 3 6 9
         *
         * 2.然后将列首和列尾元素交换即可
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        for (int line = 0; line < n; line++) {
            int l=0,r=n-1;
            while (l<=r){
                int t = matrix[line][l];
                matrix[line][l++]=matrix[line][r];
                matrix[line][r--]=t;
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new Rotate().rotate2(nums);
        MyPrintFunction.print(nums);
    }
}
