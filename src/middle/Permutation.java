package middle;

import utils.MyPrintFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    private List<String> res = new ArrayList<>();

    public String[] permutation(String s) {

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[s.length()];
        StringBuffer sb = new StringBuffer();
        dfs(chars, used, sb);

        return res.toArray(new String[res.size()]);
    }

    private void dfs(char[] chars, boolean[] used, StringBuffer path) {
        if (chars.length == path.length()) {
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (i>0 && !used[i-1] && chars[i] == chars[i-1])continue;
            if (!used[i]) {
                used[i] = true;
                path.append(chars[i]);
                dfs(chars, used, path);
                used[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "suvyls";
        String[] res = new Permutation().permutation(s);
        MyPrintFunction.print(res);
        System.out.println(Math.random());
    }
}
