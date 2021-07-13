package middle;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrder {
    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
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

        List<List<Integer>> res=levelOrder.levelOrder(root);
        for (int i=0;i<res.size();i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + "  ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null)
            return new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()){
            int n = qu.size();
            List<Integer> mid = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode temp = qu.poll();
                mid.add(temp.val);
                if (temp.left!=null)
                    qu.add(temp.left);
                if (temp.right!=null)
                    qu.add(temp.right);
            }
            res.add(mid);
        }
        return res;
    }
}
