package utils.search;

public class InsertSearch {
    public boolean search(int[]nums,int target){
        int n=nums.length;
        if (n==0)
            return false;
        return insertSearch(nums,target,0,n-1);
    }


    public boolean insertSearch(int[]nums,int target,int l,int h){
        //终止递归的条件
        if (l>h||target>nums[h]||target<nums[l])
            return false;
        //当前逻辑
        int mid = l + (target-nums[l])/((nums[h]-nums[l])*(h-l));

        if (nums[mid]==target)
            return true;
        else if (nums[mid]>target){ //向下递归
            return insertSearch(nums,target,l,mid-1);
        }
        else //if (nums[mid]<target) //向下递归
            return insertSearch(nums,target,mid+1,h);
    }


    public static void main(String[] args) {
        int[] nums = new int[20];
        for (int i = 0; i < 20; i++) {
            nums[i] = i + 1;
        }
        InsertSearch insertSearch = new InsertSearch();
        for (int i = 1; i < 25; i++) {
            System.out.println(i+"  "+insertSearch.search(nums, i));
        }
    }

}
