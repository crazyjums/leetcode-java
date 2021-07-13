package simple;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {
    public static String solution(String s) {
        if (s.length() == 0)
            return "";
        if (s.length() == 1 && s.charAt(0) != ' ')
            return s;
        int l = 0, r = s.length() - 1, n = s.length();
        StringBuffer sb = new StringBuffer(s);

        while (l < r && sb.charAt(l) == ' ')//删除空格
            l++;
        if (r == l)
            return "";
        while (l < r && sb.charAt(r) == ' ')//删除空格
            r--;
        ++r;
        sb.delete(r, n);//删除空格
        sb.delete(0, l);//删除空格

        sb.reverse();//翻转
        l = 0;
        r = 0;
        int nextStart;
        n = sb.length();
        while (true) {
            if (sb.charAt(r) == ' ') {
                sb.delete(r, r + 1);
                n--;
                continue;
            }
            while (true) {
                if (sb.charAt(r) != ' ')
                    r++;
                if (r == n)
                    break;
                if (sb.charAt(r) == ' ')
                    break;
            }
            nextStart = r--;
            while (l < r) {
                char c = sb.charAt(l);
                sb.setCharAt(l++, sb.charAt(r));
                sb.setCharAt(r--, c);
            }
            if (nextStart == n)
                break;
            l = r = nextStart + 1;
        }
        return sb.toString();
    }

    public static String solution2(String s) {
        s = s.trim();
        if (s.length() == 0)
            return "";
        int r = s.length() - 1, l = r;
        StringBuffer sb = new StringBuffer();
        while (l >= 0) {
            while (l >= 0 && s.charAt(l) != ' ')
                l--;
            sb.append(s.substring(l + 1, r + 1)).append(" ");
            while (l >= 0 && s.charAt(l) == ' ')//去除空格
                l--;
            r = l;
        }
        return sb.toString().trim();
    }



    public static void main(String[] args) {
        String[] sss = {"a", "               ", "             the sk    y      is blue          ", "  hello world!         ", "a good   example"};

//        List<StringBuffer> ss=new ArrayList<>();
//        for (int i = 0; i < sss.length; i++) {
//            ss.add(new StringBuffer(sss[i]));
//        }
        for (String s : sss) {
            System.out.println(solution(s) + " " + solution(s).length());
        }
    }
}
