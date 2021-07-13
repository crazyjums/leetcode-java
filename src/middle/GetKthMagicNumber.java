package middle;

import utils.MyPrintFunction;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

public class GetKthMagicNumber {
    public int getKthMagicNumber(int k) {
        /**
         * 下一个丑数总数有前一个数*3、*5、*7得到，且是其中最小的那个
         *  用三个指针解决，p3,p5,p7分别指向下一个数应该乘以3、5、7的数
         *  每次选取最小的那个，然后那个指针后移，循环往复
         */
        int []dp = new int[k];
        int p3=0,p5=0,p7=0;
        dp[0]=1;
        for (int i = 1; i < k; i++) {
            dp[i] = Math.min(Math.min(3*dp[p3],5*dp[p5]),7*dp[p7]);
            if (dp[i]==dp[p3]*3)p3++;
            if (dp[i]==dp[p5]*5)p5++;
            if (dp[i]==dp[p7]*7)p7++;
        }
        MyPrintFunction.print(dp);
        return dp[k-1];
    }

    public int getKthMagicNumber2(int k) {
        /**
         * 使用优先队列和集合，下一个丑数是前一个丑数中*3、*5、*7中的最小值
         * 每次去除优先队列中poll出最小值并*3、*5、*7添加到队列中，并将poll的这个
         * 数添加到集合，集合会自动去重，如果集合的大小刚好等于k,则说明找到了这个数，返回
         */
        Queue<Long> queue = new PriorityQueue<>();//优先队列
        HashSet<Long> set = new HashSet<>();
        queue.add(1L);
        while (true){
            Long val = queue.poll();//去除最小的元素
            set.add(val);
            queue.add(val*3);
            queue.add(val*5);
            queue.add(val*7);
            if (set.size()==k)
                return val.intValue();
        }
    }


    public static void main(String[] args) {
        GetKthMagicNumber getKthMagicNumber=new GetKthMagicNumber();
        System.out.println(getKthMagicNumber.getKthMagicNumber2(5));
    }
}
