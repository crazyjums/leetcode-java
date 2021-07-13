package test.niuke;

public class UpperBound {
    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public static int upper_bound_ (int n, int v, int[] a) {
        // write code here
        if (n==0)
            return 1;
        if (v>a[n-1])
            return n+1;
        int l=0,r=n-1;

        while (l<r){
            int mid = r-(r-l)/2;
            if (a[mid] >= v){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l+1;
    }

    public static void main(String[] args) {
        int[] a= {1,1,2,3,7,7,7,9,9,10};
        int n=10;
        int v=2;
        System.out.println(upper_bound_(n,v,a));
    }
}
