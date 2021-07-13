package hard;

import utils.MyPrintFunction;

import java.util.*;

public class WordBreak {
    private List<String> res = new ArrayList<>();
    private HashSet<String> words;
    private HashMap<String, List<String>> memo = new HashMap<>();//用来当缓存,map[i]表示第i个字符结尾的单词的，其组成的句子
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(s.length()==0)
            return new ArrayList<String>();
        words = new HashSet<>(wordDict);
        return dfs(s);
    }

    private List<String> dfs(String s) {
        if(memo.containsKey(s))
            return memo.get(s);
        if (s.length()==0)return new ArrayList<>();
        List<String> res = new ArrayList<>();
        for(int i = 1;i<=s.length();i++){
            String subword = s.substring(0,i);
            if(words.contains(subword)){
                if (i==s.length())
                    res.add(subword);
                else{
                    List<String> rest = dfs(s.substring(i));
                    for(String each : rest){
                        res.add(subword + " " +each);
                    }
                }
            }
        }
        memo.put(s,res);
        return res;
    }
    public List<String> wordBreak2(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<String>(wordDict), 0, map);
        List<String> breakList = new LinkedList<String>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    public List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new LinkedList<List<String>>();
            if (index == length) {
                wordBreaks.add(new LinkedList<String>());
            }
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index, i);
                if (wordSet.contains(word)) {
                    List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
                    for (List<String> nextWordBreak : nextWordBreaks) {
                        LinkedList<String> wordBreak = new LinkedList<String>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }


    public static void main(String[] args) {
        String s[] ={"catsanddog","aaaaaaa"};
        List<List<String>> wordDtcts = new ArrayList<>();
        List<String> w1 = new ArrayList<>();
        w1.add("cat");
        w1.add("cats");
        w1.add("and");
        w1.add("sand");
        w1.add("dog");

        List<String> w2 = new ArrayList<>();
        w2.add("a");
        w2.add("aa");
        w2.add("aaa");
        w2.add("aaaa");
        w2.add("aaaaa");

        wordDtcts.add(w1);
        wordDtcts.add(w2);
        WordBreak wordBreak = new WordBreak();
        for (int i = 0; i < 2; i++) {
            String tem = s[i];
            List<String> temp = wordDtcts.get(i);
            List<String> res = wordBreak.wordBreak(tem,temp);
            MyPrintFunction.print(res);
        }

        ArrayList<String> l1 = new ArrayList<String>();
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        l1.add("1");
        l2.add(1);
        System.out.println(l1.get(0).getClass());
        System.out.println(l2.get(0).getClass());
        System.out.println(l1.getClass() == l2.getClass());
    }
}
