package simple;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.lang.String;

public class RomanToInt {
    public int romanToInt(String s) {
        int res = 0;
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (i != ss.length - 1 && 'I' == ss[i] && 'V' == ss[i + 1]) {
                res += 4;
                i++;
            } else if (i != ss.length - 1 && 'I' == ss[i] && 'X' == ss[i + 1]) {
                res += 9;
                i++;
            } else if (i != ss.length - 1 && 'X' == ss[i] && 'C' == ss[i + 1]) {
                res += 90;
                i++;
            } else if (i != ss.length - 1 && 'X' == ss[i] && 'L' == ss[i + 1]) {
                res += 40;
                i++;
            } else if (i != ss.length - 1 && 'C' == ss[i] && 'D' == ss[i + 1]) {
                res += 400;
                i++;
            } else if (i != ss.length - 1 && 'C' == ss[i] && 'M' == ss[i + 1]) {
                res += 900;
                i++;
            }else if('I'==ss[i]){
                res+=1;
            }else if('V'==ss[i]){
                res+=5;
            }else if('X'==ss[i]){
                res+=10;
            }else if('L'==ss[i]){
                res+=50;
            }else if('C'==ss[i]){
                res+=100;
            }else if('D'==ss[i]){
                res+=500;
            }else if('M'==ss[i]){
                res+=1000;
            }

        }


        return res;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        String roman = "MCMXCIV";
        System.out.println(romanToInt.romanToInt(roman));

    }
}
