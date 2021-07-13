package middle;

import utils.MyPrintFunction;

import java.util.*;

public class LetterCombinations {
    private List<String> res = new ArrayList<>();
    private Map<Character,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length()==0)return res;

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        dfs(digits,0,"");

        return res;
    }

    /**
     *
     * @param digits 需要组合的数字
     * @param i 组合到第i个数字
     * @param s 组合数字的可能结果
     */
    private void dfs(String digits, int i, String s) {
        if (i==digits.length()){
            res.add(s);
            return;
        }
        for (int j = 0; j < map.get(digits.charAt(i)).length(); j++) {
            dfs(digits,i+1,s+map.get(digits.charAt(i)).charAt(j));
        }
    }

    public List<String> letterCombinations2(String digits) {
        if (digits.length()==0)return res;

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            String le = map.get(digits.charAt(i));
            int si = res.size();
            for (int j = 0; j < si; j++) {
                String t = res.remove(0);
                for (int k = 0; k < le.length(); k++) {
                    res.add(t+le.charAt(k));
                }
                System.out.println("第j="+j+"轮："+res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String di = "234";
        List<String> res = new LetterCombinations().letterCombinations2(di);
        MyPrintFunction.print(res);
    }
}
