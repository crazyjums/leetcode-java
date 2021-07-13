package middle;

public class MaxArea {
    public int maxArea(int[] height) {
        /**
         * 思路：
         * 使用双指针，从左右两边向中间遍历，每次遍历记录面积最大值
         * 指针移动的标准是：当某一边的高度更小时，一定该指针
         */
        int max=0;
        int l = 0,r=height.length-1;
        while (l<r){
            max = Math.max(max,(r-l)*(Math.min(height[l],height[r])));
            if (height[l]<height[r])
                l++;
            else
                r--;
        }
        return max;
    }

    public static void main(String[] args) {
        int[]nums={1,8,6,2,5,4,8,3,7};
        int res = new MaxArea().maxArea(nums);
        System.out.println(res);
    }
}
