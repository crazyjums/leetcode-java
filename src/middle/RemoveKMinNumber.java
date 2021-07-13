package middle;

import java.util.Stack;

public class RemoveKMinNumber {
    private static int c1 = 0;
    private static int c2 = 0;
    private static int c3 = 0;

    public int removeKMinNumber(int num, int k) {
        if (k == 0)
            return num;
        if (k == String.valueOf(num).length())
            return 0;

        StringBuffer nums = new StringBuffer().append(num);

        for (int j = 0; j < k; j++) {
            for (int i = 0; i < nums.length() - 1; i++) {
                if (nums.charAt(i) > nums.charAt(i + 1)) {
                    nums.replace(i, i + 1, "");
                    c1++;
                    break;
                } else if (nums.charAt(i) < nums.charAt(i + 1)) {
                    if (i == nums.length() - 2) {
                        nums.replace(i + 1, i + 2, "");
                        c1++;
                    } else
                        continue;
                }
            }
        }

        return Integer.parseInt(nums.toString());
    }

    /**
     * 优化1
     *
     * @param num
     * @param k
     * @return
     */
    public int removeKMinNumber2(int num, int k) {
        if (k == 0)
            return num;
        if (k == String.valueOf(num).length())
            return 0;

        StringBuffer nums = new StringBuffer().append(num);

        int start = 0;
        for (int j = 0; j < k; j++) {
            for (int i = start; i < nums.length() - 1; i++) {
                if (nums.charAt(i) > nums.charAt(i + 1)) {
                    start = i;
                    nums.replace(i, i + 1, "");
                    c2++;
                    break;
                } else if (nums.charAt(i) < nums.charAt(i + 1)) {
                    if (i == nums.length() - 2) {
                        start = i;
                        nums.replace(i + 1, i + 2, "");
                        c2++;
                    } else
                        continue;
                }
            }
        }

        return Integer.parseInt(nums.toString());
    }

    public int removeKMinNumber3(int num, int k) {
        if (k == 0)
            return num;
        if (k == String.valueOf(num).length())
            return 0;
        StringBuffer nums = new StringBuffer().append(num);
        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < nums.length(); j++) {
            while (!stack.isEmpty() && stack.peek() > nums.charAt(j) && k>0){
                stack.pop();
                k--;
            }
            stack.push(nums.charAt(j));
        }
        nums.delete(0,nums.length());
        while (!stack.isEmpty())
            nums.insert(0,stack.pop());
        return Integer.parseInt(nums.toString());
    }

    public static void main(String[] args) {
        int n = 41270936;
        int k = 3;
        RemoveKMinNumber removeKMinNumber = new RemoveKMinNumber();
        int res = removeKMinNumber.removeKMinNumber(n, k);
        int res2 = removeKMinNumber.removeKMinNumber3(n,k);
        System.out.println(n + "->" + res+"，计算次数："+c1);
        System.out.println(n + "->" + res2+"，计算次数："+c2);

    }
}
