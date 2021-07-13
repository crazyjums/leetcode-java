package simple;

public class CompressString {
    public static String solution(String s){
        if (s.length()<=2)
            return s;
        StringBuffer ss = new StringBuffer().append(s).append(" ");
        StringBuffer sb = new StringBuffer();
        int l=0,r=0;
        for (int i = 0; i < ss.length(); i++) {
            if (ss.charAt(l)==ss.charAt(i))
                continue;
            sb.append(ss.charAt(l)).append(i-l);
            l=i;
        }
        if (sb.length()>=s.length())
            return ss.toString().trim();
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String[] ss = {"aaab","aabcccccaaa","abbccd","a","aa","aaa"};
        for(String s:ss){
            System.out.println(solution(s));
        }
    }
}
