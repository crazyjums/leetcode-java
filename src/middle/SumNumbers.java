package middle;

import utils.MyPrintFunction;
import utils.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        if (root==null)return 0;
        return dfs(root,0);
    }

    private int dfs(TreeNode root, int pre) {
        if (root==null)
            return 0;
        int sum = pre * 10 + root.val;
        if (root.left==null&&root.right==null)
            return sum;
        return dfs(root.left,sum) + dfs(root.right,sum);
    }

    public int sumNumbers2(TreeNode root) {
        if (root==null)return 0;
        Queue<TreeNode> queue = new LinkedList<>();//存放当前节点
        Queue<Integer> queue1 = new LinkedList<>();//存放当前节点表示的值
        queue.add(root);
        queue1.add(root.val);
        int sum = 0;
        while (!queue.isEmpty() && !queue1.isEmpty()){
            TreeNode t = queue.poll();
            int pre = queue1.poll();
            if (t.left==null&&t.right==null)
                sum += pre;
            if (t.left!=null){
                queue.add(t.left);
                queue1.add(pre*10+t.left.val);
            }
            if (t.right!=null){
                queue.add(t.right);
                queue1.add(pre*10+t.right.val);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node5;
        node2.right=node4;

        MyPrintFunction.levelOrderBinaryTree(root);

        SumNumbers sumNumbers = new SumNumbers();
        int res = sumNumbers.sumNumbers(root);
        System.out.println(res);
        System.out.println(sumNumbers.sumNumbers2(root));
    }


}
