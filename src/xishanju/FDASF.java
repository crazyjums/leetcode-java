package xishanju;

import utils.MyPrintFunction;
import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FDASF {

    private List<Integer> res = new ArrayList<>();
    private int ans = Integer.MAX_VALUE;
    private int pre = 0;
    public void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        ans = Math.min(ans, Math.abs(root.val - pre));
        pre = root.val;
        inOrder(root.right);
    }

    public int getMinGap(TreeNode root) {
        if (root == null) return 0;
        inOrder(root);
        return ans;
    }

    public void getMinGap() {
        System.out.println("duotai");
    }

    public double getMinGap(int a) {
        return a * 2.3;
    }

    public static void main(String[] args) throws InterruptedException {
        String d = "1  2 www.leetcode.com";
        String[] s = d.split("\\s+");
        MyPrintFunction.print(s);
        String[] ss = "discuss.leetcode.com".split("\\.");
        MyPrintFunction.print(ss);
        FDASF fdasf = new FDASF();
        fdasf.getMinGap();
        System.out.println(fdasf.getMinGap(34));
        Queue<Integer> ddd = new LinkedList<>();
        ddd.peek();

    }

}
