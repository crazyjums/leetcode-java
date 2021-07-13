package simple;

import java.util.ArrayList;
import java.util.List;

public class Generate2 {
    public static void main(String[] args) {
//        Generate2 generate2 = new Generate2();
//        MyPrint myPrint = new MyPrint();
//        int num = 0;
//        List<Integer> res = generate2.getRow(num);
//        myPrint.printList(res);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
//        if (rowIndex == 0)
//            return res;
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> tem = new ArrayList<>();
        tem.add(1);
        triangle.add(tem);

        for (int i = 1; i < rowIndex+1; i++) {
            List<Integer> t = new ArrayList<>();
            t.add(1);
            for (int j = 1; j < i; j++) {
                t.add(triangle.get(i-1).get(j) + triangle.get(i-1).get(j-1));
            }
            t.add(1);
            triangle.add(t);
        }

        return triangle.get(rowIndex);
    }
}
