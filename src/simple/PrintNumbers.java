package simple;

import utils.MyPrintFunction;

public class PrintNumbers {
    public int[] printNumbers(int n) {
        double max = Math.pow(10.0,(double)n);
        int[]res =new int[(int)max-1];
        for(int i=0;i<max-1;i++){
            res[i]=i+1;
        }
        return res;
    }

    public static void main(String[] args) {
        MyPrintFunction.print(new PrintNumbers().printNumbers(1));
    }
}
