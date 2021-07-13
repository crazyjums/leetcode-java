package middle;

import java.util.ArrayList;
import java.util.List;


public class GenerateParenthesis {
    private static List<String> res = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        generate(0, 0, n, "");
        return res;
    }

    private static void generate(int left, int right, int n, String s) {
        //退出条件
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        if (left < n)//添加左括号
            generate(left + 1, right, n, s + "(");
        if (left > right)//添加右括号
            generate(left, right + 1, n, s + ")");
    }


    public static void main(String[] args) {
        int n = 6;
        List<String> res = generateParenthesis(n);
        System.out.println(res.size());
        System.out.println(res);
    }
}
