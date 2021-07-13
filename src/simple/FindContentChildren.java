package simple;

import utils.MyPrintFunction;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        /**
         * 思路：
         *      使用贪心算法+排序（倒序->从前往后遍历，顺序->从后往前遍历）
         *      每次使用最大的饼干区满足胃口最大的小孩，由于进行了排序，然后下一个小孩的胃口一定
         *      没有当前小孩的胃口大，一直比较下去
         *      - 如果当前的饼干大于等于当前的小孩的胃口，那么就满足他
         *      - 如果当前的饼干小于当前的小孩的胃口，那么就只能放弃满足该小孩了，继续给下一个小孩分饼干
         */
        int res=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gi=g.length-1,si=s.length-1;
        while (gi>=0&&si>=0){
            if (s[si]>=g[gi]){
                gi--;
                si--;
                res++;
            }else
                gi--;

        }
        return res;
    }

    public static void main(String[] args) {
        FindContentChildren findContentChildren =new FindContentChildren();
        int []g = {1,3,2};
        int[]s={1,2};
        int res =findContentChildren.findContentChildren(g,s);
        System.out.println(res);
    }
}
