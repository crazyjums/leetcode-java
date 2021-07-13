package simple;

import javax.print.DocFlavor;

/**
 *给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 *  
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        String strs = "   hello world    ";
        System.out.println(lengthOfLastWord.solution2(strs));

    }

    public String getStrap(String s){
        int l = s.length();
        System.out.println(l);
        int i = l-1;
        for (; i>=0 ; i--) {
            if (s.charAt(i)!=' ')
                break;
        }
        return s.substring(0,i+1);
    }

    public int solution(String strs){
        int len = getStrap(strs).length();
        int i=len-1,j=0;
        for (; i >=0; i--) {
            if (strs.charAt(i)==' ' && i==len-1)
                continue;
            if (strs.charAt(i)!=' '){
                j++;
            }else
                break;
        }
        return j;
    }

    public int solution2(String strs){
        int len = strs.length();
//        if (len==0)
//            return 0;
        int i=len-1,j=0;
        while(i>=0&&strs.charAt(i)==' ') i--;
        while(i>=0&&strs.charAt(i)!=' ') {
            i--;
            j++;
        }
        return j;
    }
}

