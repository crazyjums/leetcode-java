package middle;

import utils.MyPrintFunction;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        /**
         * 思路：
         *   假设n=2:
         *     00 -> 0
         *     01 -> 1
         *     10 -> 2
         *     11 -> 3
         *
         *     此时需要得到n=3时的序列，那么可以在n=2的基础上进行操作，使用动态规划的思想：
         *     1.先对前面的数的最高位加0，值并没有变化
         *            000 -> 0
         *          * 001 -> 1
         *          * 010 -> 2
         *          * 011 -> 3
         *     2、此时对后面的pow(2,n-1)=（1<<(n-1)）位进行求值，
         *     对最高位加1，有
         *          000 -> 0
         *          001 -> 1
         *          010 -> 2
         *          011 -> 3
         *          ---
         *          100 -> 4
         *          101 -> 5
         *          110 -> 6
         *          111 -> 7
         *         此时发现，第4行和第5行的3个bit都不同，那么需要如果反过来看，就刚好符号graycode的要求了
         *         000 -> 0
         *         001 -> 1
         *         010 -> 2
         *         011 -> 3
         *         ---
         *         111 -> 7
         *         110 -> 6
         *         101 -> 5
         *         100 -> 4
         *         可以返现，将新增的行，反着相加，
         *          - 第5行的低位采用第4行的低位
         *          - 第6行的低位采用第3行的低位
         *          - 第7行的低位采用第2行的低位
         *          - 第8行的低位采用第1行的低位
         *          对原来的结果集倒叙遍历加上1<<(n-1)即可
         *
         */
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            int add = 1<<i;//相当于2的i次方
            for (int j = res.size()-1; j >=0 ; j--) {
                res.add(res.get(j)+add);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        List<Integer> res = new GrayCode().grayCode(n);
        MyPrintFunction.print(res);
    }
}
