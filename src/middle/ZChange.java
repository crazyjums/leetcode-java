package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZChange {
    public String convert(String s, int numRows) {
        /**
         * 思路：
         * 1.按照给定的numRows创建一个numRows个StringBuffer用于存放可变长的字符串
         * 按照z字形变换，先按照从上到下的顺序往不同的StringBuffer中添加字符，然后向下或者
         * 向上走，当StringBuffer的索引等于0（到大z字形的上边界）或者等于numRows-1（到大Z字形的下边界）
         * 时改变方向，使用+1或者-1来实现方向改变
         */
        if (s==null||s.length()==0||numRows<=1)return s;
        List<StringBuffer> sb = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            sb.add(new StringBuffer());
        }
        int sbIndex = 0;
        int dir = 1;
        for (int i = 0; i < s.length(); i++) {

            sb.get(sbIndex).append(s.charAt(i));
            sbIndex+=dir;
            if (sbIndex==0||sbIndex==numRows-1){
                dir=-dir;
            }
        }
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            res.append(sb.get(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        System.out.println(new ZChange().convert(s,3));
    }
}
