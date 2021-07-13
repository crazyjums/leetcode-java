package secondTime;

import utils.MyPrintFunction;
import utils.tree.TreeNode;

public class IsBalanced {
    /**
     * 思路：
     * 判断一棵树是否是平衡二叉树的根据市树的深度差最大不会大于1
     * 1. 先判断根节点的左右子树的深度差是否小于等于1，如果不是则返回false
     *    如果是，则说明根节点的左右子树满足条件，但是，左右子树未必满足条件，
     *    则再判断root左右子树是否是平衡二叉树
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root==null)
            return true;
        return (Math.abs(maxDepth(root.right)-maxDepth(root.left))<=1) && isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public static void main(String[] args) {
        TreeNode root=TreeNode.getATree();
        IsBalanced isBalanced = new IsBalanced();
        boolean res = isBalanced.isBalanced(root);
        System.out.println(res);
    }
}
