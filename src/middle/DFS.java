package middle;

import utils.tree.MyTreeTrversal;
import utils.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class DFS {

    public void preOrderTrversal(TreeNode root){
        if (root!=null){
            System.out.print(root.getVal()+"  ");
            preOrderTrversal(root.getLeft());
            preOrderTrversal(root.getRight());
        }
    }

    public List<Integer> midOrderTrversal(TreeNode root){
        List<Integer> res = new LinkedList<>();
        if (root!=null){
            midOrderTrversal(root.getLeft());
            System.out.print(root.getVal()+"  ");
            midOrderTrversal(root.getRight());
        }
        return res;
    }

    public void afterOrderTrversal(TreeNode root){
        if (root!=null){
            afterOrderTrversal(root.getLeft());
            afterOrderTrversal(root.getRight());
            System.out.print(root.getVal()+"  ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getATree();

        DFS dfs = new DFS();
        System.out.println("树的中序遍历：");
        dfs.midOrderTrversal(root);
        System.out.println();
        System.out.println("树的前序遍历：");
        dfs.preOrderTrversal(root);
        System.out.println();
        System.out.println("树的后序遍历：");
        dfs.afterOrderTrversal(root);
        System.out.println();

    }

}
