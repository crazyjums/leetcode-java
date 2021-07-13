package middle;

import java.util.Arrays;

public class ReorganizeString {
    public String reorganizeString(String s) {
        int n = s.length();
        if (n < 2) return s;
        int[] chars = new int[26];// 统计s中每个字符出现的次数
        int max_size = (n + 1) >> 1;
        int max_char_index = 0; //出现次数最多的字符的下标
        int max_chars = 0; //出现次数最多的字符的出现次数
        for (int i = 0; i < n; i++) {
            chars[s.charAt(i) - 'a']++;
            if (chars[s.charAt(i) - 'a'] > max_chars) {
                max_char_index = s.charAt(i) - 'a';
                max_chars ++;
            }
            if (chars[s.charAt(i) - 'a'] > max_size)
                return "";
        }
        char[] res = new char[n];
        int index = 0;
        for (int i = 0; i < n; i+=2) {
            if (chars[max_char_index] > 0)
                res[i] = (char) (max_char_index + 'a');
            chars[max_char_index]--;
            index = i;
        }
//        int index = 0;
//        while (chars[max_char_index]-- > 0) {
//            res[index] = (char) (max_char_index + 'a');
//            index += 2;
//        }
//        int index = 1;
        for (int i = 0; i < chars.length; i ++) {
            while (chars[i]-- > 0) {
                if (index >= n)
                    index = 1;
                res[index] = (char) (i + 'a');
                index += 2;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String s = "bfrbs";
        System.out.println(new ReorganizeString().reorganizeString(s));
    }
}
