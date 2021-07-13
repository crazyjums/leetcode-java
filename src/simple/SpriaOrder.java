package simple;

import utils.MyPrintFunction;

import java.util.Arrays;
import java.util.Comparator;

public class SpriaOrder {
    public int[] spiralOrder(int[][] matrix) {
        // if (matrix.length == 1) matrix[0];
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                res[index ++] = matrix[top][i];
            }
            for (int i = top + 1; i <= bottom; i++) {
                res[index ++] = matrix[i][right];
            }
            if (top < bottom && left < right) {
                for (int i = right - 1; i > left; i--) {
                    res[index ++] = matrix[bottom][i];
                }
                for (int i = bottom; i > top; i--) {
                    res[index ++] = matrix[i][left];
                }
            }
            top ++;
            left ++;
            bottom --;
            right --;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3,10},{4,5,6,11},{7,8,9,12}};
        int[][] matrix = {{3},{2}};
        int[] res = new SpriaOrder().spiralOrder(matrix);
        MyPrintFunction.print(res);
        Integer[] a = new Integer[3];
        Arrays.sort(a, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        MyPrintFunction.print(a);
    }
}
