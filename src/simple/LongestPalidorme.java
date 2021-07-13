package simple;

import utils.MyPrintFunction;

import java.util.HashMap;
import java.util.Map;

public class LongestPalidorme {
    public static int longestPalindrome(String s) {
        int[] count = new int[52];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)>='A' && s.charAt(i)<='Z')
                count[s.charAt(i)-'A']++;
            else if (s.charAt(i)>='a'&&s.charAt(i)<='z')
                count[s.charAt(i)-'a'+26]++;
        }
        int res = 0;//用来统计最长回文的长度
        for (int i = 0; i < count.length; i++) {
            res += count[i];
            if ((count[i]&1)==1){
                res--;
            }
        }
        return res<s.length()?res+1:res;
    }

    public static void main(String[] args) {
        String s = "aaAaaa";
        int res = longestPalindrome(s);
        System.out.println(res);
    }
}
