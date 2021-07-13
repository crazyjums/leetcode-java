package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数n，求所有可能的合法括号序列只有'('和')'
 */
public class generateParenthesis {
    private List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n){
        dfs(0,0,n,"");
        return res;
    }

    /**
     *
     * @param left 表示枚举中已经存在的左括号的个数
     * @param right 右括号的个数
     * @param n 括号的个数，一共有2*n个括号
     * @param s 可能的组合
     */
    private void dfs(int left, int right, int n, String s) {
        /**
         * 退出条件：
         * 当可能组合中有2*n个括号时，表示这是一个可能解，
         * 或者当左右括号分别达到了n个时，也是一种可能解
         */
        if (s.length()==2*n){ //也可以用 if(left==n && right==n)来判断
            res.add(s);
            return;
        }
        /**
         * 当枚举可能中的左括号的个数小于给定的个数时，说明还可以继续放左括号
         * 但是左括号一定在右括号之前放置，所以可以进行一定的剪纸枝
         */
        if (left<n)
            dfs(left+1,right,n,s+"(");
        if (left>right) //如果枚举结果中的左括号个数小于右括号的个数，说明不能再放了
            dfs(left,right+1,n,s+")");
    }

    public static void main(String[] args) {
        int n = 4;
        List<String> res = new generateParenthesis().generateParenthesis(n);
        System.out.println(res);
    }

}
