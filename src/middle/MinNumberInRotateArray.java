package middle;

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) return 0;

        int l = 0, r = array.length - 1;
        int mid = 0;
        while (l < r) {
            if (array[l] < array[r])
                return array[l];
            mid = l + (r - l)/2;
            if (array[mid] > array[r]) {
                l = mid + 1;
            } else if (array[mid] < array[r]) {
                r = mid - 1;
            } else{
                r --;
            }
        }
        return array[l];
    }

    public static void main(String[] args) {
        int [] array = {5,6,7,8,1,2,3,4};
        System.out.println(new MinNumberInRotateArray().minNumberInRotateArray(array));
    }
}
