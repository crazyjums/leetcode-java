package utils;

import utils.tree.TreeNode;

import java.math.BigInteger;
import java.util.*;


public class Test {

    public Test() {
        System.out.println("Test这是构造函数");
    }

    {
        System.out.println("Test这是构造代码块");
    }

    static {
        System.out.println("Test这是静态代码块");
    }


    //    static int n1;
//    int n2;
//    int n3;
//    {
//        n3=300;
//        System.out.println("普通代码块，n3="+n3);
//    }
//    {
//        n2=200;
//        System.out.println("普通代码块，n2="+n2);
//    }
//
//    static {
//        n1=100;
//        System.out.println("静态代码块，n1="+n1);
//    }
//    public static void main(String[] args) {
//        System.out.println("创建第一个实例");
//        Test test = new Test();
//        System.out.println("n1="+n1);
//        System.out.println("n2="+test.n2);
//        System.out.println("n3="+test.n3);
//        System.out.println("创建第二个实例");
//        Test test2 = new Test();
//
//    }
    public static List<Integer> postOrder(TreeNode root) {
        if (null == root)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t.left != null) {
                stack.push(t.left);
            }
            if (t.right != null) {
                stack.push(t.right);
            }
            res.add(0,t.val);
        }
        return res;
    }

    static int topK(int k, int[] array) {
        if (array == null || array.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }


        return 0;
    }

    static List<String> getAll(int length, int start, int end, String input) {
        char[] tem = new char[2 * (end - start)];
        for (int i = start; i < end; i++) {
            tem[i - start] = Character.toLowerCase(input.charAt(i));
        }
        for (int i = 0; i < 1 + start; i++) {
            tem[i + start] = Character.toUpperCase(tem[i]);
        }
        

        return null;
    }
    public static void main(String[] args) {
        TreeNode root = TreeNode.getATree();
        MyPrintFunction.postOrder(root);
        MyPrintFunction.print(postOrder(root));
        getAll(11, 3, 7, "123abcd2222");
    }

}

