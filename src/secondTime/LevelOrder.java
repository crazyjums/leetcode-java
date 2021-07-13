package secondTime;

import utils.MyPrintFunction;
import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static int[] levelOrder(TreeNode root) {
        /**
         * 思路：
         *   - 使用一个队列来存放层序打印的顺序，队列是先进先出操作，
         *   所以只要按照每次添加左节点，然后再添加右节点的顺序，就是
         *   从左到右，从上到下打印
         *
         *   - 特殊情况：
         *     - 如果root等于空，直接返回一个空数组即可
         */

        List<Integer> res = new ArrayList<>();
        if (root==null)
            return res.stream().mapToInt(Integer::intValue).toArray();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode t = queue.poll();
            res.add(t.val);
            if (t.left!=null)
                queue.add(t.left);
            if (t.right!=null)
                queue.add(t.right);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getATree();
        int[]res = levelOrder(root);
        MyPrintFunction.print(res);
    }
}
