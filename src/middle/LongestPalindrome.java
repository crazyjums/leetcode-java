package middle;

import java.util.Arrays;

public class LongestPalindrome {
    public static String solution(String s) {
        if (s.length() < 2)
            return s;
        int start, end;
        int maxl = 0, maxlen = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                start = i;
                end = j;
//                boolean isv = false;
//                while (start<end){
//                    if (s.charAt(start)==s.charAt(end)){
//                        start++;
//                        end--;
//                    }else{
//                        isv=false;
//                        break;
//                    }
//                }
//                if (start>=end){
//                    isv=true;
//                }
                if (j - i + 1 > maxlen && isSysmetry(s, i, j)) {
                    maxl = i;
                    maxlen = j - i + 1;
                }
            }
        }
        return s.substring(maxl, maxlen + maxl);
    }

    public static boolean isSysmetry(String s, int l, int r) {
        if (s.length() < 2)
            return true;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static String solution2(String s) {
        if (s.length() < 2)
            return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0, maxlen = 1;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    /**
                     * 当子串的首尾字符相等时，如果其长度等于2或者等于3的话，则就是回文串
                     * 换句话说，如果子串的长度等于3或2，则只需要判断一下首尾字符是否相等，
                     * 相等的画就是回文
                     */
                    if (j - i < 3) { //j-i<3 是由 j-1-(i+1)+1>2  化简得来
                        dp[i][j] = true;
                    } else {
                        /**
                         * 如果长度大于3，则取决于其子串是否是回文串，
                         * 因为子串是回文串，再在子串的首尾加上两个相同的
                         * 字符，则父串也是回文串
                         */
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                /**
                 * 如果当前子串是回文串，且其长度大于之前记录的最大长度
                 * 则记录当前的最大长度和起始位置
                 */
                if (dp[i][j] && j - i + 1 > maxlen) { //j-i+1表示子串的下标区间
                    start = i;
                    maxlen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxlen);
    }

    public static String solution3(String s) {
        if (s.length() < 2)
            return s;
        int start = 0, maxlen = 1;
        for (int i = 0; i < s.length(); i++) {
            int max = expand(s, i,i);
            int max2 = expand(s,i,i+1);
            max = Math.max(max,max2);
            if (max > maxlen) {
                start = i - (max-1) / 2;
                maxlen = max;
            }
        }
        return s.substring(start, start + maxlen);
    }

    //返回最长回文的长度
    public static int expand(String s, int i,int j) {
        while (i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }

    public static void main(String[] args) {
        String[] ss = {"aa","babab", "abc", "aabb","bb"};

//        for (String s : ss) {
//            System.out.println(solution(s));
//        }
        System.out.println("solution2:");
        for (String s : ss) {
            System.out.println(solution3(s));
        }
    }
}
