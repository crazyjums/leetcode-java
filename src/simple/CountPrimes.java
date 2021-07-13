package simple;

import org.junit.Test;

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] nums = new boolean[n];//默认值都是false

        int c = 0;
        for (int i = 2; i < n; i++) {
            if (!nums[i]) {//是质数
                c++;
                for (int j = i + i; j < n; j += i) {
                    nums[j] = true;
                }
            }
        }

        return c;
    }

    public int solution2(int n) {
        boolean[] nums = new boolean[n];
        int c = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (nums[i])//不是质数
                continue;
            for (int j = 2 * i; j < n; j += 2 * i) {
                if (nums[i]) {
                    c--;
                    nums[i] = true;
                }
            }
        }
        return c;
    }



    public static void main(String[] args) {
        int n = 64;
        CountPrimes countPrimes = new CountPrimes();
        System.out.println(countPrimes.countPrimes(n));
        System.out.println(countPrimes.solution2(n));
    }
}
