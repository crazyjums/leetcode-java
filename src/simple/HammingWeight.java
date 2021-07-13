package simple;

public class HammingWeight {
    public int hammingWeight(int n) {
        int s = 0;
        if (n == 0)
            return s;
        while (n != 0) {
            s++;
            n &= (n - 1);
        }
        return s;
    }

    public static void main(String[] args) {
        int num = 16;
        System.out.println(new HammingWeight().hammingWeight(num));
    }
}
