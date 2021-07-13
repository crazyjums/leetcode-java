package middle;

import utils.MyPrintFunction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GetPermutation {
    private List<String> res = new ArrayList<>();

    public String getPermutation(int n, int k) {
        if (k < 0 || n < 0)
            return null;

        boolean[] used = new boolean[n];
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        StringBuffer path = new StringBuffer();
        bachTrack(used, nums, path);
        return res.get(k-1);
    }

    private void bachTrack(boolean[] used, int[] nums, StringBuffer path) {
        //1.退出条件
        if (nums.length == path.length()) {
            res.add(path.toString());
            return;
        }
        //2.当前逻辑
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.append(nums[i]);//没有被使用过的数字，添加到排列末尾
                used[i] = true;//表示当前数字已经被用过
                bachTrack(used, nums, path);//继续向下遍历寻找没有被使用过的数字

                used[i] = false;//下一层的节点上的数字被使用过了，就回溯到上一个节点
                //并将已经添加到末尾的数字删除
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public String getPermutation2(int n, int k) {
        /**
         * 思路：
         *      回溯算法超时，由于是一个1到n的升序数组，所以可以计算每个位置上具体是什么数字
         */
        if (k<0||n<0)return null;
        int fab[]=new int[n];
        fab[0]=1;
        for (int i = 1; i < n; i++) {
            fab[i] = fab[i-1]*i;
        }
        --k;
        /**
         用一个数组（或者链表）存储可以挑选的数字，每次选完一个，将其删除，然后继续挑选，
         直到选完每个位置上的数字
         **/
        List<Integer> nums=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i+1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n-1; i >=0; i--) {
            int order = k/fab[i];
//            System.out.println("order="+order+" k="+k);
            sb.append(nums.get(order));
            nums.remove(order);
            k -= order * fab[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GetPermutation getPermutation = new GetPermutation();
        int n = 4;
        int k = 9;
        System.out.println(getPermutation.getPermutation2(n, k));
    }

}
