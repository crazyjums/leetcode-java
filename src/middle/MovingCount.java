package middle;

public class MovingCount {

    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k < 0) return 0;
        boolean[][] used = new boolean[m][n];
        return dfs(m, n, k, used, 0, 0);
    }

    private int dfs(int m, int n, int k, boolean[][] used, int i, int j) {
        System.out.println("i="+i+",j="+j+",sumi="+getDigitsSum(i)+",sumj="+getDigitsSum(j));
        if (i < 0 || i >= m || j < 0 || j >= n || used[i][j] || getDigitsSum(i) + getDigitsSum(j) > k)
            return 0;
        used[i][j] = true;
        return 1 + dfs(m, n, k, used, i, j + 1) +
                   dfs(m, n, k, used, i + 1, j);// +
    }

    private boolean check(int m, int n, int k, boolean[][] used, int i, int j) {
        if (i >= 0 && i < m && j >= 0 && j < n && !used[i][j] && getDigitsSum(i) + getDigitsSum(j) <= k)
            return true;
        return false;
    }


    private int getDigitsSum(int num) {
        if (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum;
        }
        return num;
    }

    private int getSum(int num){
        int sum = 0;
        while (num>0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int m = 11, n = 8, k = 16;
        MovingCount movingCount = new MovingCount();
        int res = movingCount.movingCount(m, n, k);
        System.out.println(res);
        System.out.println(movingCount.getDigitsSum(10));
        System.out.println(movingCount.getSum(10));
    }
}
