package simple;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    //链表实现
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        } else{
            List<Integer> tem = new ArrayList<>();
            tem.add(1);
            res.add(tem);
            for (int i = 1; i < numRows; i++) {
                List<Integer> t = new ArrayList<>();
                t.add(1);
                for (int j = 1; j < i; j++) {
                    t.add(res.get(i-1).get(j) + res.get(i-1).get(j-1));
                }
                t.add(1);
                res.add(t);
            }
        }
        return res;
    }

    //数组实现
    public int[][] generate2(int numRows) {
        int[][] res = new int[numRows][numRows];
        if (numRows == 0)
            return res;
        else{
            res[0][0] = 1;
            for (int i = 1; i < numRows; i++) {
                res[i][0] = 1;
                res[i][i] = 1;
                for (int j = 1; j < i; j++) {
                    res[i][j] = res[i - 1][j] + res[i - 1][j - 1];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        Generate generate = new Generate();
//        MyPrint myPrint = new MyPrint();
//        int nums = 5;
//
//        List<List<Integer>> res = generate.generate(nums);
//        myPrint.printDoubleList(res);
//
//        int[][] res2 = generate.generate2(nums);
//        myPrint.printTwoDimArray(res2);
    }
}
