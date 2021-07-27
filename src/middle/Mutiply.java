package middle;


public class Mutiply {
    public int multiply(int A, int B) {
        //退出条件
        if (B==0)
            return 0;
        //自身逻辑
        int min = Math.min(A,B);
        int max = Math.max(A,B);
        //向下循环
        return max+multiply(max,min-1);
    }

    public static void main(String[] args) {
        int a=13,b=4;
        Mutiply mutiply = new Mutiply();
        System.out.println(mutiply.multiply(a,b));
    }
}
