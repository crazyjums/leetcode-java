package secondTime;

public class StockMac {
    public int solution(int[]nums){
        if (nums.length<=1)return 0;
        int minPrice = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            minPrice = Math.min(nums[i],minPrice);
            max = Math.max(nums[i]-minPrice,max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[]nums = {9,11,8,5,7,12,16,14};
        StockMac stockMac = new StockMac();
        int res = stockMac.solution(nums);
        System.out.println(res);

    }
}
