package utils.search;

public class BinarySearch {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0)
            return false;
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid = r-(r-l)/2;
            if (nums[mid]==target)
                return true;
            else if(nums[mid] > target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[20];
        for (int i = 0; i < 20; i++) {
            nums[i] = i + 1;
        }
        BinarySearch binarySearch = new BinarySearch();
        for (int i = 1; i < 25; i++) {
            System.out.println(i+"  "+binarySearch.search(nums, i));
        }

    }
}
