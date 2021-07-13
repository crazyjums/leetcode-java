package simple;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntReverse {
    public int reverse(int x) {
        int res = 0;
        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
            return res;
        }
        while (x != 0) {
            int lastNumber = x % 10;
            if (res > (Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && lastNumber > 7))
                return 0;
            if (res < (Integer.MIN_VALUE / 10) || (res == Integer.MIN_VALUE / 10 && lastNumber < -8))
                return 0;
            res = res * 10 + lastNumber;
            x /=  10;
        }

        return res;
    }

    public static void main(String[] args) {
        IntReverse intReverse = new IntReverse();
        int x = 1234566;
        System.out.println(intReverse.reverse(x));
    }
}
