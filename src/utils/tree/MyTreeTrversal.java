package utils.tree;


import java.util.*;

public class MyTreeTrversal {
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

        MyTreeTrversal myTreeTrversal = new MyTreeTrversal();
        System.out.println("树的中序遍历：");
        myTreeTrversal.midOrderTrversal(root);
        System.out.println();
        System.out.println("树的前序遍历：");
        myTreeTrversal.preOrderTrversal(root);
        System.out.println();
        System.out.println("树的后序遍历：");
        myTreeTrversal.afterOrderTrversal(root);
        System.out.println();
        System.out.println("树的层次遍历：");
        List<List<Integer>> res = myTreeTrversal.layerOrderTrversal(root);
        for (int i=0;i<res.size();i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
