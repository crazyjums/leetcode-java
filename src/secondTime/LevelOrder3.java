package secondTime;

import utils.tree.TreeNode;

import java.util.*;

public class LevelOrder3 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        /**
         * 思路：
         *   使用双端队列进行插入元素，当遍历到奇数层时，每次的节点值添加到双端队列的头部，偶数层时，添加到尾部
         */
        if (root==null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 0;
        while (!queue.isEmpty()){
            int n = queue.size();
            LinkedList<Integer> mid = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                TreeNode t = queue.poll();
                if ((i&1)==0) mid.addLast(t.val);//奇数层
                else mid.addFirst(t.val);//偶数层
                if (t.left!=null)queue.add(t.left);
                if (t.right!=null)queue.add(t.right);
            }
            i++;
            res.add(mid);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getATree();
        System.out.println(new LevelOrder2().levelOrder(root));
        List<List<Integer>> res = new LevelOrder3().levelOrder(root);
        System.out.println(res);
    }
}
