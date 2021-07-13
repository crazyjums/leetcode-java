package simple;

import utils.MyPrintFunction;

import java.util.HashSet;

public class LongestWord {
    public String longestWord(String[] words) {
        /**
         解题思路：暴力解法
         **/
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
        String res="";
        for (String word:words) {
            //如果当前单词的长度大于res的长度，或者长度刚好相等且字典序较小，则更新
            if (word.length()>res.length() || (word.length()==res.length() && word.compareTo(res)<0)){
                boolean flag = true;
                for (int i = 1; i < word.length(); i++) {
                    if (set.contains(word.substring(0,i)))continue;//如果集合中该单词前缀，继续遍历
                    else{
                        flag = false;
                        break;
                    }
                }
                if (flag)res=word;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[]ss={"w","wo","wor","worl", "world","nihaohao"};
        String res = new LongestWord().longestWord(ss);
        System.out.println(res);

        int []a={1,2,3};
        int []b={1,2,4};

        System.out.println();

        String[] str = {"abv","adf","dfg","gd","poi","ww","xyt"};
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str.length-i-1; j++) {
                if (str[j].compareTo(str[j+1])>0){
                    String t = str[j+1];
                    str[j+1]=str[j];
                    str[j]=t;
                }
            }
        }
        MyPrintFunction.print(str);
        String data = "[]";
        String s = data.substring(1,data.length()-1);
        if (s.length()==0) System.out.println(123124);
        System.out.println(data.substring(1,data.length()-1));

    }
}
