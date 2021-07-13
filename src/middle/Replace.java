package middle;

import utils.MyPrintFunction;

import java.util.Arrays;
import java.util.HashSet;

public class Replace {
    public int respace(String[] dictionary, String sentence) {
        if (sentence==null || sentence.length() == 0)return 0;
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(Arrays.asList(dictionary));
        int []dp=new int[sentence.length()+1];//dp[i]表示句子中前i个字符最少未匹配的字符数
        /**
         * 如果第i个字符没有在字典中，则dp[i]=dp[i-1]+1，即前面的未匹配字符数加1，
         * 如果第j到第i个字符在字典中，（j<i），则需要未匹配字符不要增加，直接dp[i]=dp[j即可]
         */
        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = 0; j < i; j++) {
                if (hashSet.contains(sentence.substring(j,i)))//j<i
                    dp[i] = Math.min(dp[i] , dp[j]);
            }
        }
        MyPrintFunction.print(dp);
        return dp[sentence.length()];
    }

    public static void main(String[] args) {
        String [] dic = {"looked","just","like","her","brother"};
        String sentence = "jesslookedjustliketimherbrother";
        Replace replace = new Replace();
        int res = replace.respace(dic,sentence);
        System.out.println(res);
    }
}
