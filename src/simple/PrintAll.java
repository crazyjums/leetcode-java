package simple;

import java.util.ArrayList;
import java.util.List;

public class PrintAll {
    private List<String> res = new ArrayList<>();

    public List<String> printAll(int n) {
        dfs(0, 0, "", 2 * n);
        return res;
    }

    private void dfs(int left, int right, String path, int n) {
        if (path.length() == n) {
            res.add(path);
            return;
        }
        if (left < n / 2)
            dfs(left + 1, right, path + "(", n);
        if (left > right)
            dfs(left, right + 1, path + ")", n);
    }
    char[] chars = {'0','1','2','3','4','5','6','7','8','9'};
    public List<String> ontToN(int n){
        char []nums = new char[n];
        dfs2(0,n,nums);
        return res;
    }

    /**
     * 对一个有n位数的整数的第x为进行排列
     * @param x
     */
    private void dfs2(int x,int n,char[]nums){
        if (x==n){
            res.add(String.valueOf(nums));
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            nums[x] = chars[i];
            dfs2(x+1,n,nums);
        }
    }



    public static void main(String[] args) {
        int n = 3;
        PrintAll printAll = new PrintAll();
        List<String> res = printAll.ontToN(n);
        System.out.println(res);
    }
}
