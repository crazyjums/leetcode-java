package simple;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayForm {
    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> B = new ArrayList<>();
        while (K > 0) {
            int tem = K % 10;
            B.add(0, tem);
            K /= 10;
        }
        int len1 = A.length;
        int len2 = B.size();
        int i = len1 - 1, j = len2 - 1;
        int carry = 0;
        List<Integer> res = new ArrayList<>();
        while (i >= 0 || j >= 0) {
            int add1 = i >= 0 ? A[i] : 0;
            int add2 = j >= 0 ? B.get(j) : 0;
            int added = add1 + add2 + carry;
            if (added > 9) {
                carry = 1;
                res.add(0, added % 10);
            } else {
                carry = 0;
                res.add(0, added);
            }
            i--;
            j--;
        }
        if (carry == 1) {
            res.add(0, 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {9,9,9,9,9,9,9,9,9,9};
        int K = 1;
        System.out.println(addToArrayForm(A, K));
    }
}
