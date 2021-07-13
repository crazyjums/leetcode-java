package middle;

public class FindDuplicate {
    public int findDuplicate(int[]nums){
        int fast=0; //代表快指针，fast的值表示链表的value
        int slow=0; //代表慢指针，slow的值表示链表的value
        while (true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow==fast)
                break;

        }
        fast = 0;
        while (true){
            fast = nums[fast];
            slow = nums[slow];
            if (fast== slow)
                break;
        }
        return slow;
    }

    public static void main(String[] args) {
//        int [] nums = {2,5,9,6,9,3,8,9,7,1};
//        int [] nums = {3,1,3,4,2};
        int[]nums = {4,3,3,3,2};
        FindDuplicate findDuplicate = new FindDuplicate();
        int res = findDuplicate.findDuplicate(nums);
        System.out.println(res);
    }
}
