package test;


import java.util.*;

public class T0107 {
    //给两个Lista,b，实现两个List两个List的并集，即合并两个List，重复的元素只保留一个。
//不可以调用现成的集合方法
//有空闲限制，a的长度是m，b的长度是n，额外空间最多用m+n(不是O(m+n))
//尝试优化下，最少的时间复杂度是多少，在代码注释里给出最终的时间复杂度

    public static List<Integer> union(List<Integer> a, List<Integer> b) {
        //在这儿实现

        //method 1
//        List ans = new ArrayList<>();
//        for (int i = 0; i < a.size(); i++) {
//            if (!ans.contains(a.get(i)))
//                ans.add(a.get(i));
//        }
//        for (int i = 0; i < b.size(); i++) {
//            if (!ans.contains(b.get(i)))
//                ans.add(b.get(i));
//        }
//        return ans;

        //method 2
//        Set<Integer> ans = new HashSet<>();
//        for (int i = 0; i < a.size(); i++) {
//            ans.add(a.get(i));
//        }
//        for (int i = 0; i < b.size(); i++) {
//            ans.add(b.get(i));
//        }
//        return new ArrayList<>(ans);

        //method 3
        for (int i = 0; i < a.size(); i++) {
            if (!b.contains(a.get(i)))
                b.add(a.get(i));
        }
        return b;
    }
}
