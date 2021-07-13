package simple;

public class ReverseLeftWords {
    /**
     * 三步走：
     * 1.对整个字符串进行翻转
     * 2.将[0,len-n-1]内的字符串进行翻转，即将需要向左移动的后半部分进行翻转，
     *  如：s=abcdefg,n=2,则第一次翻转后s=gfedcba,左移动之后的后半部分即原始字符串中的cdefg,但是第一次翻转后，该部分
     *  到字符串前面去了
     * 3.将[len-n,len-1]内的字符串翻转，即左移动后的前半部分
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        String s1 = reverse(s,0,s.length()-1);
        int l1=0,r1=s.length()-n-1,l2=s.length()-n,r2=s.length()-1;
        String s2 = reverse(s1,l1,r1);
        return reverse(s2,l2,r2);
    }

    /**
     *
     * @param s 需要翻转的字符串
     * @param i 需要翻转的起始位置
     * @param j 需要翻转的终止位置
     * @return 返回翻转后的字符串
     */
    private String reverse(String s,int i,int j){//闭区间
        StringBuffer sb = new StringBuffer(s);
        while (i<=j){
            char c = sb.charAt(i);
            sb.setCharAt(i++,sb.charAt(j));
            sb.setCharAt(j--,c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "lrloseumgh";
        int n=6;
        ReverseLeftWords reverseLeftWords= new ReverseLeftWords();
        String res = reverseLeftWords.reverseLeftWords(s,n);
        System.out.println(res);
    }
}
