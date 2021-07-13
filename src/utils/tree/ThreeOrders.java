package utils.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeOrders {
    private List<Integer> pre = new ArrayList<>();
    private List<Integer> mid = new ArrayList<>();
    private List<Integer> post = new ArrayList<>();
    public int[][] threeOrders(TreeNode root){
        int[][]res = new int[3][];
        pre(root);
        res[0]=pre.stream().mapToInt(Integer::intValue).toArray();
        mid(root);
        res[1]=mid.stream().mapToInt(Integer::intValue).toArray();
        post(root);
        res[2]=post.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }

    private void pre(TreeNode root){
        if (root!=null){
            pre.add(root.val);
            pre(root.left);
            pre(root.right);
        }
    }

    private void mid(TreeNode root){
        if (root!=null){
            mid(root.left);
            mid.add(root.val);
            mid(root.right);
        }
    }

    private void post(TreeNode root){
        if (root!=null){
            post(root.left);
            post(root.right);
            post.add(root.val);
        }
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.getATree();
        ThreeOrders threeOrders = new ThreeOrders();
        int[][]res =threeOrders.threeOrders(root);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(res));
    }
}
