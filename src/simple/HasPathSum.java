package simple;

import utils.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        /**使用两个队列来实现，
         *  基于二叉树的层序遍历思路：
         *   - 先将根节点加入队列1，并将根节点的值加入队列2，
         *   - 进入循环，取出队列1和队列2的第一个元素，如果取出的元素没有左右子树，便是叶子节点
         *      - 然后再判断从根节点一直到当前节点的值是否和sum相等，如果相等则返回true，否则返回false
         *   - 如果不相等，则继续进行层序遍历，添加当前节点的左节点，并将左节点的值和之前计算的sum进行相加，
         *   即计算路径和
         *
         */
        if (root == null)
            return false;

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queue1 = new LinkedList<>();
        queue.add(root);
        queue1.add(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int tem = queue1.poll();
            if (node.left == null && node.right == null)
                if (tem == sum)
                    return true;
                else
                    continue;

            if (node.left != null) {
                queue.add(node.left);
                queue1.add(tem + node.left.val);
            }
            if (node.right != null) {
                queue.add(node.right);
                queue1.add(tem + node.right.val);
            }
        }
        return false;
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null)
            return false;
        /**
         * 使用递归的思想进行解题，，每次用sum减去根节点的值，如果当前节点还有左右子树的的话，
         * 则继续递归，如果没有的话。则判断当前根节点的值是否和sum相等，相等则返回true，否则返回false
         */

        if (root.left == null && root.right == null)
            if (root.val == sum)
                return true;

        return hasPathSum2(root.left, sum - root.val) ||
                hasPathSum2(root.right, sum - root.val);
    }

    private boolean res = false;

    public boolean hasPathSum3(TreeNode root, int sum) {
        if (root == null) return false;

        /**
         * 使用递归+前序遍历：
         *
         */
        preOrder(root,sum);
        return res;
    }


    private void preOrder(TreeNode root, int sum) {
        if (root != null) {
            if (root.left == null && root.right == null&&sum - root.val == 0)
                res = true;
            preOrder(root.left, sum - root.val);
            preOrder(root.right, sum - root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getATree();
        HasPathSum hasPathSum = new HasPathSum();
        boolean res = hasPathSum.hasPathSum3(root, 148);
        System.out.println(res);
    }
}
