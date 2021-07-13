package simple;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int [] res = digits;
        if (digits[n-1]<=8){
            res[n-1]+=1;
            return res;
        }else{
            int f=1;
            res[n-1]=0;
            for (int i = digits.length-2; i >=0 ; i--) {
                if (digits[i]+f>=10){
                    res[i] = res[i]+f-10;
                    f=1;
                }else{
                    res[i] = res[i] + f;
                    f=0;
                }
            }
            if (f==1){
                int[] res2 = new int[n+1];
                res2[0] = 1;
                System.arraycopy(res2,1,res,0,n);
                return res2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int [] dig = {9,9,9,9};
        System.out.println(Arrays.toString(plusOne.plusOne(dig)));
    }
}
