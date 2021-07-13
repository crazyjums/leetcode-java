package middle;

import utils.MyPrintFunction;
import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftLevel = countLevel(root.left);
        int rightLevel = countLevel(root.right);

        //说明当前左子树是一个满二叉树
        if (leftLevel == rightLevel) {
            return countNodes(root.right) + (1 << leftLevel);
        } else { //说明当前的右子树是一个满二叉树
            return countNodes(root.left) + (1 << rightLevel);
        }
    }

    private int countLevel(TreeNode root) {
        if (root == null) return 0;
        int h = 0;
        while (root != null) {
            h ++;
            root = root.left;
        }
        return h;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        MyPrintFunction.levelOrderBinaryTree(root);
        int res = new CountNodes().countNodes(root);
        System.out.println(res);

        List<Integer> a = new ArrayList<>();
        a.stream().mapToInt(Integer::intValue).toArray();
    }
}
