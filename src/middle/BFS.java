package middle;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public List<List<Integer>> layerOrderTrversal(TreeNode root){
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
                mid.add(temp.getVal());
                if (temp.getLeft()!=null)
                    qu.add(temp.getLeft());
                if (temp.getRight()!=null)
                    qu.add(temp.getRight());
            }
            res.add(mid);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getATree();

        BFS bfs = new BFS();
        System.out.println("树的层次遍历：");
        List<List<Integer>> res = bfs.layerOrderTrversal(root);
        for (int i=0;i<res.size();i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
