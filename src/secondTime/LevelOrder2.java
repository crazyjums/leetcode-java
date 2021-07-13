package secondTime;

import utils.MyPrintFunction;
import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder2 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){

            int n = queue.size();
            List<Integer> a = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode t = queue.poll();
                a.add(t.val);
                if(t.left!=null)
                    queue.add(t.left);
                if(t.right!=null)
                    queue.add(t.right);
            }
            res.add(a);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getATree();
        LevelOrder2 levelOrder2 = new LevelOrder2();
        List<List<Integer>> res = levelOrder2.levelOrder(root);
        System.out.println(res);
    }
}
