package utils.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        // write code here
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> mid = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode t = queue.poll();
                mid.add(t.val);
                if (t.left!=null)
                    queue.add(t.left);
                if (t.right!=null)
                    queue.add(t.right);
            }
            res.add(mid);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getATree();
        List<List<Integer>> res = new LevelOrder().levelOrder(root);
        System.out.println(res);
    }
}
