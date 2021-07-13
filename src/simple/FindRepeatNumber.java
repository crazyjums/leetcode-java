package simple;

public class FindRepeatNumber {
    public static int solution(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != i) {
                if (a[a[i]]==a[i])
                    return a[i];
                else {
                    int t = a[a[i]];
                    a[a[i]] = a[i];
                    a[i] = t;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 1, 0, 2, 5, 3};
        System.out.println(solution(nums));
    }
}
