package secondTime;

import utils.MyPrintFunction;

public class Heap2 {

    public void buildHeap(int[] a,int size) {
        /**
         * root index: i
         *  -> left child: 2*i+1
         *  ->right child: 2*i+2
         *  从倒数第一个非叶子节点开始调整：倒数第一个非叶子节点坐标: (n-2)/2
         */
        for (int i = size / 2; i >=0; i--) {
            downAdjust(a, i,a.length);
        }
    }

    public void delete(int[]a){
        a[0]=a[a.length-1];
        upAdjust(a,a.length-1);
    }
    public int sort(int []nums,int K){
        for (int i = nums.length/2; i >=0 ; i--) {
            downAdjust(nums,i,nums.length);
        }
        int index = 0;
        for (int i = nums.length-1; i >0 ; i--) {
            if (index++>=K-1)
                break;
            System.out.print("i="+i+",index="+index+" ");
            MyPrintFunction.print(nums);
            int t = nums[i];
            nums[i]=nums[0];
            nums[0]=t;
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

    private void upAdjust(int[] a,int size) {
        int childIndex = size-1;
        int pIndex = (2*childIndex-1)/2;
        int tem = a[childIndex];
        while (childIndex>0 && tem > a[pIndex]){
            a[childIndex] = a[pIndex];
            childIndex = pIndex;
            pIndex = (2*childIndex-1)/2;
        }
        a[childIndex]=tem;
    }



    public static void main(String[] args) {
        int[] a = {3,2,3,1,2,4,5,5,6};
        Heap2 heap2 = new Heap2();
        int res=heap2.sort(a,4);

        MyPrintFunction.print(a);
        System.out.println(res);
    }
}
