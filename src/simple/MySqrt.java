package simple;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MySqrt {
    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        int[] test = {2147395599,25,36,49,37};
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i] + ":" + mySqrt.mySqrt2(test[i]));
        }

    }

    public int mySqrt(int n) {
        if (n <=1)
            return n;
        int res = 0;
        int l=0,r=n;
        while (l<=r){
            int mid=l+(r-l)/2;
            if ((long)mid*mid<=n){
                res=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return res;
    }

    public int mySqrt2(int n) {
        if (n <=1)
            return n;
        int t = n/2;
        for (int i = 0; i < t; i++) {
            if ((long)t*t==n)
                return t;
            else if ((long)t*t>n){
                if ((long)(t-1)*(t-1)<n)
                    return t-1;
                t/=2;
            }else{
                if ((long)(t+1)*(t+1)>n)
                    return t;
                t++;
            }
        }
        return t;
    }
}
