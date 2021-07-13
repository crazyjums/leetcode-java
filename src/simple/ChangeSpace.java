package simple;

public class ChangeSpace {
    public static String solution(String s){
        int n=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' ')
                n++;
        }
        StringBuffer sb = new StringBuffer(s);
        sb.setLength(s.length()+2*n);
        int p1=s.length()-1,p2=sb.length()-1;
        while (p1!=p2){
            while (sb.charAt(p1)!=' '){
                sb.setCharAt(p2--,sb.charAt(p1--));
            }
            sb.setCharAt(p2--,'0');
            sb.setCharAt(p2--,'2');
            sb.setCharAt(p2--,'%');
            p1--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "Directed by Gaspar Noé. With";
        String res = solution(s);
        System.out.println(res);
    }
}
