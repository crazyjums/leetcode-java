package middle;

import utils.MyPrintFunction;

public class TranslateNum {
    private int total = 0;

    public int translateNum(int num) {
        if (num < 0) return 0;
        String s = String.valueOf(num);
        if (s.length() < 2)
            return 1;
        int[] dp = new int[s.length() + 1];//dp[i]表示以第i位数字结尾的数字，总共有dp[i]种翻译
        dp[0] = dp[1] = 1;
        int p_2 = 1;
        int p_1 = 1;
        int p = 0;
        for (int i = 1; i < s.length(); i++) {
//            dp[i + 1] = dp[i];//一个字符都可以翻译，所以至少可以翻译一次
            p = p_1;
            int t = Integer.parseInt(s.substring(i-1,i+1));
            if (t > 9 && t < 26)//表示如果是两位数合在一起，也可以翻译
            {
//                dp[i + 1] = dp[i - 1] + dp[i];
                p = p_1 + p_2;
            }
            p_2 = p_1;
            p_1 = p;
        }
//        return dp[s.length()];
        return p;
    }

    private void dfs(String s, int path) {
        if (path == s.length()) {
            total++;
            return;
        }
        for (int i = 1; i < s.length(); i++) {
            String sub = s.substring(i);
            if (Integer.parseInt(sub) >= 0 && Integer.parseInt(sub) <= 25) {
                path += sub.length();
                dfs(s.substring(i), path);
                path -= sub.length();
            }
        }

    }
    private long atoi(String s){
        int len = s.length();
        char[] cc = s.toCharArray();
        long res = 0;
        for(int i=0;i<len;i++){
            res += (cc[i]-'0')* Math.pow(10,len-i-1);
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 12258;
        TranslateNum translateNum = new TranslateNum();
        int res = translateNum.translateNum(n);
        System.out.println(res);
        long a = 100;
        System.out.println((int)a);
        System.out.println(translateNum.atoi("423"));
    }
}
