package xishanju;

public class test1 {

    public int solution(String s1,String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1>n2){ //S1 更短
            String s = s1;
            s1 = s2;
            s2 = s;
        }

        return 0;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "cab";
        int res = new test1().solution(s1,s2);
        System.out.println(res);
    }
}
