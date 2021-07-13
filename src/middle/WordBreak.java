package middle;

import utils.MyPrintFunction;

import java.util.LinkedList;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        if (n==0)return true;
        
        boolean [] dp = new boolean[n+1];//dp[i]表示s的前i为字符是否在字典中
        dp[0]=true;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n+1; j++) {
                if (dp[i] && wordDict.contains(s.substring(i,j)))
                    dp[j] = true;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        List<String> wd = new LinkedList<>();
        wd.add("leet");
        wd.add("code");
        String s = "leetcode";
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak(s,wd));
    }
}
