package secondTime;

public class ReverseStr {
    public String solve (String str) {
        // write code here
        if (str.length()<=1)
            return str;
        StringBuffer sb = new StringBuffer(str);
        int l=0,r=sb.length()-1;
        while(l<r){
            char c = sb.charAt(l);
            sb.setCharAt(l++,sb.charAt(r));
            sb.setCharAt(r--,c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "abcdefg";
        System.out.println(new ReverseStr().solve(a));
    }

}
