package simple;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StrStr {
    // solution one
    public int strStr(String haystack, String needle) {
        int res = -1;
        if (needle.length() == 0) {
            return 0;
        }
        int hay_len = haystack.length();
        int need_len = needle.length();
        String temp="";
        int round = hay_len - need_len + 1;
        for (int i = 0; i < round; i++) {
            temp=haystack.substring(i,i+need_len);
            if (temp.equals(needle)){
                return i;
            }
        }
        return res;
    }
    //solution two
    public int strStr2(String haystack, String needle) {
        int res = -1;
        if (needle.length() == 0) {
            return 0;
        }
        int hay_len = haystack.length();
        int need_len = needle.length();
        for (int i = 0; i < hay_len-need_len+1; i++) {
            if (haystack.substring(i,i+need_len).hashCode()==needle.hashCode())
                return i;
        }
        return res;
    }
    //solution three
    public int strStr3(String haystack, String needle) {
        int res = -1;
        int hay_len = haystack.length();
        int need_len = needle.length();
        if (need_len == 0) {
            return 0;
        }else if (need_len>hay_len) {
            return res;
        }

        char c = needle.charAt(0);
        for (int i = 0; i < hay_len-need_len+1; i++) {
            if (haystack.charAt(i)==c){
                if (haystack.substring(i,i+need_len).hashCode()==needle.hashCode())
                    return i;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        StrStr strstr = new StrStr();
        String[] all = {"aaa","zhuhonggen","hello"};
        String[] needle = {"a","zhg","ll"};
        for (int i = 0; i < all.length; i++) {
            System.out.println(strstr.strStr3(all[i], needle[i]));
        }
//        System.out.println(strstr.strStr2(all, needle));
    }
}
