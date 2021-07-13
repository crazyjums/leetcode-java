package simple;

import utils.tree.TreeNode;

import java.util.*;

public class LevelOrderBottom {
    public static void main(String[] args) {
        LevelOrderBottom levelOrderBottom = new LevelOrderBottom();
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


        List<List<Integer>> res = levelOrderBottom.levelOrderBottom(root);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + "   ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (null==root){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> m = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode t = queue.poll();
                m.add(t.getVal());
                if (t.getLeft()!=null){
                    queue.add(t.getLeft());
                }
                if (t.getRight()!=null){
                    queue.add(t.getRight());
                }
            }
            res.add(0,m);
        }
        return res;
    }

}
