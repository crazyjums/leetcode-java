package secondTime;

public class UpperBpund {
    public int upper_bound_(int n, int v, int[] a) {
        // write code here
        if (n == 0)
            return 1;
        if (v > a[n - 1])
            return n + 1;
        int l = 0, r = n - 1;
        int mid = r - (r - l) / 2;
        while (l < r) {
            if (a[mid] >= v) {
                r = mid;
            } else {
                l = mid + 1;
            }
            mid = r - (r - l) / 2;
        }
        return mid + 1;
    }

    public static void main(String[] args) {
        int[]a={1,2,4,4,5};
        int n=5;
        int v=4;
        UpperBpund upperBpund = new UpperBpund();

        System.out.println(upperBpund.upper_bound_(n,v,a));
    }

}
