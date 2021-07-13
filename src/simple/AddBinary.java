package simple;

import java.util.Arrays;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddBinary {
    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String s1 = "1111";
        String s2 = "1";
        System.out.println(addBinary.solution(s1, s2));

    }

    public String solution(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        while (l1 > l2) {
            s2 = '0' + s2;
            l2++;
        }
        while (l1 < l2) {
            s1 = '0' + s1;
            l1++;
        }
        String res = "";
        int f = 0;
        for (int i = l1 - 1; i >= 0; i--) {
            if ((s1.charAt(i) + s2.charAt(i) - 96 + f) >= 2) {
                res = String.valueOf((char) (s1.charAt(i) + s2.charAt(i) - 48 + f -2) ) + res;
                f = 1;
            } else {
                res = String.valueOf((char) (s1.charAt(i) + s2.charAt(i) - 48 + f)) + res;
                f = 0;
            }
        }
        if (f == 1) {
            res = '1' + res;
        }
        return res;
    }
}
