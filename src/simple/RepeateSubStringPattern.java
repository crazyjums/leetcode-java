package simple;

public class RepeateSubStringPattern {
    public static boolean solution(String s) {
        int i=1;
        while (i<s.length()){
            if (s.charAt(0)!=s.charAt(i))
                i++;
            else
                break;
        }
        if (i==s.length())
            return false;
        if (s.length()%i!=0)
            return false;
        int j=i;
        i=0;
        for (; j < s.length(); j++) {
            if (s.charAt(i)==s.charAt(j)){
                i++;
            }else{
                return false;
            }
        }
        return true;
    }

    public static boolean solution2(String s){
        String ss = s+s;
        return ss.substring(1,ss.length()-1).contains(s);
    }

    public static void main(String[] args) {
        String[] ss = {"abaababaab","abab", "abcabcabcabc", "aba", "sadfasd","a","aaa","abcab"};
        for (String s : ss) {
            System.out.println(solution(s));
        }
    }
}
