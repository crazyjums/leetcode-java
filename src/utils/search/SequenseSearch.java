package utils.search;

public class SequenseSearch {
    public boolean search(int[]nums,int target){
        if (nums.length==0)
            return false;
        for (int i = 0; i < nums.length; i++) {
            if (target==nums[i])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[20];
        for (int i = 0; i < 20; i++) {
            nums[i] = i + 1;
        }
        SequenseSearch binarySearch = new SequenseSearch();
        for (int i = 1; i < 25; i++) {
            System.out.println(i+"  "+binarySearch.search(nums, i));
        }
    }
}
