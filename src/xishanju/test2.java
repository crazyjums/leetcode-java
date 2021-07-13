package xishanju;

import java.util.ArrayList;
import java.util.List;

public class test2 {
    /**
     * @param forward int整型一维数组
     * @return int整型
     */
    public int minMove(int[] forward) {
        // write code here
        int n = forward.length;
        int min = 1;
        int step = forward[0];
        while (step<n){
            if (step + forward[step] > n)
                break;
            step = forward[step];
            min++;

        }
        return min;
    }


    public static void main(String[] args) {
//        int[] nums = {3, 7, 1, 1, 1, 1, 2, 1};
//        int res = new test2().minMove(nums);
//        System.out.println(res);

        List<String> s = new ArrayList<>();
        s.add("word");
        s.add("nihao");

        System.out.println(String.join(" ",s));
    }
}
