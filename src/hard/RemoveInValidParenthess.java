package hard;

import utils.MyPrintFunction;

import java.util.*;

public class RemoveInValidParenthess {
    public List<String> removeInvalidParentheses(String s) {
        /*
        思路：使用回溯算法进行求解所有可能，使用集合保存最后的结果并去重
        如何判断是否是删除的最小数量的无效括号：
            - 如果当前待添加到结果集中的字符的长度大于结果集中的某个字符串的长度，则清空set，添加当前字符串
            - 如果小于，则跳过
            - 如果等于，则添加到set

        任何字符都有两种结果，一是添加到当前路径字符串中，二是不添加到当前路径字符串中
        */
        Set<String> ans = new HashSet<>();
        dfs(s, 0, "", 0, 0, ans);
        Iterator<String> it = ans.iterator();
        List<String> res = new ArrayList<>();
        while (it.hasNext()) {
            res.add(it.next());
        }
        return res;
    }

    private void dfs(String s, int index, String path, int left, int right, Set<String> ans) {
        if (left < right) { //右括号对于左括号 直接结束
            return;
        }
        if (index == s.length()) { //到达字符串结尾
            if (left == right && isValid(path)) { //左右括号相等
                if (ans.isEmpty()) {
                    ans.add(path);
                } else if (!ans.isEmpty()){
                    Iterator<String> it = ans.iterator();
                    String tem = it.next();
                    if (path.length() == tem.length())
                        ans.add(path);
                    else if (tem.length() < path.length()) {
                        ans.clear();
                        ans.add(path);
                    } else
                        return;
                }
//                if (!ans.isEmpty() && path.length() == ans.iterator().next().length())
//                    ans.add(path);
//                else if (!ans.isEmpty() && path.length() > ans.iterator().next().length()) {
//                    ans.clear();
//                    ans.add(path);
//                } else if (!ans.isEmpty() && path.length() < ans.iterator().next().length())
//                    return;
//                ans.add(path);
            }
            return;
        }
        //添加当前字符
        if (s.charAt(index) == '(') {
            dfs(s, index + 1, path + "(", left + 1, right, ans);
        } else if (s.charAt(index) == ')') {
            dfs(s, index + 1, path + ")", left, right + 1, ans);
        } else {
            dfs(s, index + 1, path + s.charAt(index), left, right, ans);
        }
        //不添加当前字符
        if (s.charAt(index) == '(' || s.charAt(index) == ')')
            dfs(s, index + 1, path, left, right, ans);

    }

    private boolean isValid(String s) {
        int min = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(')
                min ++;
            else if (s.charAt(i) == ')') {
                min --;
                if (min < 0)
                    return false;
            }
        }
        return min == 0;
    }

    public static void main(String[] args) {
        String s = "(a)())()";
        List<String> res = new RemoveInValidParenthess().removeInvalidParentheses(s);
        MyPrintFunction.print(res);
    }
}
