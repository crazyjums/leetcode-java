package secondTime;

public class ReverseWords {
    public String reverseWords(String s){
        if (s.length()==0)
            return "";
        //去除前后的空格
        int i=0,j=s.length()-1;
        while (i<j){//去除左边的空格
            if (i<j&&s.charAt(i)==' ')
                i++;
            else
                break;
        }
        while (i<j)//去除右边的空格
            if (i<j&&s.charAt(j)==' ')
                j--;
            else
                break;
        i--;
        j++;
        String s1 = reverse(s,i,j);
        int k=0;
        while (k<=j){
            while (s1.charAt(k)!=' ')
                k++;
            s1 = reverse(s1,i,k-1);

        }
        return "";
    }

    private String reverse(String s,int i,int j){//闭区间
        StringBuffer sb = new StringBuffer(s);
        while (i<=j){
            char c= sb.charAt(i);
            sb.setCharAt(i++,sb.charAt(j));
            sb.setCharAt(j--,c);
        }
        return sb.toString();
    }




    public static void main(String[] args) {
        String s = "  fucking   hello    world!    ";
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(
                reverseWords.reverseWords(s)
        );
    }
}
