package niuke;

import utils.MyPrintFunction;

import java.util.*;

public class Permutation {
    private HashSet<String> res = new HashSet<>();
    public ArrayList<String> Permutation(String str) {
        if (str.length()<=1)return new ArrayList<>();
        char[] chars= str.toCharArray();
        boolean[]used=new boolean[chars.length];
        StringBuilder sb = new StringBuilder();
        dfs(chars,used,sb);
        ArrayList<String> result=new ArrayList<>();
        Iterator<String> iterator = res.iterator();
        while (iterator.hasNext()){
            result.add(iterator.next());
        }
        Collections.sort(result);
        return result;
    }

    private void dfs(char[] chars, boolean[] used, StringBuilder path) {
        if (path.length()==chars.length){
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!used[i]){
                if (i>0&&path.length()>0&&chars[i]==path.charAt(path.length()-1))continue;
                path.append(chars[i]);
                used[i]=true;
                dfs(chars,used,path);
                used[i]=false;
                path.deleteCharAt(path.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        ArrayList<String> res= new Permutation().Permutation(s);
        MyPrintFunction.print(res);
        System.out.println(res.size());

        List<List<Integer>> a=new ArrayList<>();
        List<Integer> b1 = new ArrayList<>();
        b1.add(1);
        b1.add(2);
        b1.add(5);
        List<Integer> b2 = new ArrayList<>();
        b2.add(1);
        b2.add(2);
        b2.add(4);

        a.add(b1);
        a.add(b2);
        MyPrintFunction.print(a);
        MyPrintFunction.print(a);
    }
}
