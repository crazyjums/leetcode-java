package middle;


import utils.MyPrintFunction;

public class FindKthWithHeap {
    public int sort(int []nums,int K){
        for (int i = nums.length/2; i >=0 ; i--) {
            downAdjust(nums,i,nums.length);
        }
        int index = 0;
        for (int i = nums.length-1; i >0 ; i--) {
            if (index++>=K-1)
                break;
            int t = nums[i];
            nums[i]=nums[0];
            nums[0]=t;
            System.out.print("size="+i+",index="+index+" ");
            MyPrintFunction.print(nums);
            downAdjust(nums,0,i);
        }
        return nums[0];
    }
    /**
     * @param a: array
     * @param i: root index
     */
    private void downAdjust(int[] a, int i,int n) {
        int childIndex = 2 * i + 1;//left child index
        int tem = a[i];
        while (childIndex < n) {
            //when left child less than right child, left->right
            if (childIndex + 1 < n && a[childIndex] < a[childIndex + 1]) {
                childIndex++;
            }
            if (tem > a[childIndex]) //大顶堆
                break;
            a[i] = a[childIndex];
            i = childIndex; //向下继续查找
            childIndex = 2 * childIndex + 1;
        }
        a[i] = tem;
    }

    public static void main(String[] args) {
        int[] a = {3,2,3,1,2,4,5,5,6};
        FindKthWithHeap findKthWithHeap = new FindKthWithHeap();
        int res = findKthWithHeap.sort(a,4);
        System.out.println(res);
    }
}
