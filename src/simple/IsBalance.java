package simple;

import utils.tree.MyTreeTrversal;
import utils.tree.TreeNode;

import java.util.List;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsBalance {
    public static void main(String[] args) {
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
        r.getLeft().getRight().setRight(new TreeNode(120));
        IsBalance isBalance = new IsBalance();

        MyTreeTrversal myTreeTrversal = new MyTreeTrversal();
        List<List<Integer>> res = myTreeTrversal.layerOrderTrversal(root);
        for (int i=0;i<res.size();i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + "  ");
            }
            System.out.println();
        }
        System.out.println(isBalance.isBlance(root));
    }

    public boolean isBlance(TreeNode root){
        if (root==null)
            return true;
        else
            return Math.abs(getDpeth(root.getLeft())-getDpeth(root.getRight()))<=1 && isBlance(root.getLeft()) && isBlance(root.getRight());
    }


    public int getDpeth(TreeNode root){
        if (root==null)
            return 0;
        else {
            int left = getDpeth(root.getLeft());
            int right = getDpeth(root.getRight());
            return Math.max(left,right)+1;
        }
    }
}
