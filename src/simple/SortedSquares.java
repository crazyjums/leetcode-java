package simple;

import utils.MyPrintFunction;

public class SortedSquares {
    /**
     * 双指针方法。
     * @param A
     * @return
     */
    public static int[] sortedSquares(int[] A) {
        int []res=new int[A.length];
        int left=0,right=A.length-1;
        int index = right;
        while (left<=right){
            if (Math.abs(A[right]) > Math.abs(A[left])){
                res[index--] = (A[right] *A[right]);
                right--;
            }else{
                res[index--] = (A[left] *A[left]);
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[]nums={-4,-3,0,5,10};
        MyPrintFunction.print(nums);
        int[]res = sortedSquares(nums);
        MyPrintFunction.print(res);
    }
}
