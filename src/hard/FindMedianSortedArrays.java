package hard;

public class FindMedianSortedArrays {
    //暴力解法
    public double solution1(int []nums1,int[]nums2){
        int n = nums1.length+nums2.length;
        int []ns = new int[n];
        System.arraycopy(nums1,0,ns,0,nums1.length);
        System.arraycopy(nums2,0,ns,nums1.length,nums2.length);
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (ns[j] > ns[j+1]){
                    int t = ns[j];
                    ns[j] = ns[j+1];
                    ns[j+1]=ns[j];
                }
            }
        }
        int m = n/2;
        double mid=0.0;
        if (n%2==0){
            mid = (ns[m] + ns[m-1])/2.0;
        }else{
            mid = ns[m];
        }
        return mid;
    }

    public static void main(String[] args) {
        int []n1={1,2,3};
        int []n2={3,};
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();

        double res = findMedianSortedArrays.solution1(n1,n2);
        System.out.println(res);
    }
}
