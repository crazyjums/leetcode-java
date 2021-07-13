package simple;

public class LastRemaining {
    public int lastRemaining(int n, int m) {
        int p = 0;
        boolean[] nums = new boolean[n];
        int count = n;
        while (count > 1) {
            for (int i = 0; i < n; i++) {
                if (!nums[i]) p++;
                if (p == m) {
                    nums[i] = true;
                    count --;
                    p = 0;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            if (!nums[i]) {
                res = i;
                break;
            }
        return res;
    }

    public static void main(String[] args) {
        int res = new LastRemaining().lastRemaining(5, 1);
        System.out.println(res);
    }
}
