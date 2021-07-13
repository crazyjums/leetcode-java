package simple;

import utils.tree.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxDepth {
    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        TreeNode root = new TreeNode(2);
        root.setLeft(new TreeNode(4));
        root.setRight(new TreeNode(12));
        TreeNode l = root.getLeft();
        l.setRight(new TreeNode(80));
        l.setLeft(new TreeNode(100));
        l.getRight().setLeft(new TreeNode(62));
        l.getRight().setRight(new TreeNode(70));
        TreeNode r = root.getRight();
        r.setLeft(new TreeNode(50));
        r.setRight(new TreeNode(57));
        r.getLeft().setRight(new TreeNode(58));

        System.out.println(maxDepth.solution(root));

    }

    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = solution(root.getLeft());
            int right = solution(root.getRight());
            return Math.max(left,right) +1;
        }
    }
}
