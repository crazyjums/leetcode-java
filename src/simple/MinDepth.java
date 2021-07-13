package simple;

import middle.LevelOrder;
import utils.tree.TreeNode;

public class MinDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.setLeft(new TreeNode(4));
//        root.setRight(new TreeNode(12));
//        TreeNode l = root.getLeft();
//        l.setRight(new TreeNode(80));
//        l.setLeft(new TreeNode(100));
//        l.getRight().setLeft(new TreeNode(62));
//        l.getRight().setRight(new TreeNode(70));
//        TreeNode r = root.getRight();
//        r.setLeft(new TreeNode(50));
////        r.setRight(new TreeNode(57));
//        r.getLeft().setRight(new TreeNode(58));

        MinDepth minDepth = new MinDepth();
        System.out.println(minDepth.minDepth(root));

    }
    public int minDepth1(TreeNode root) {
         if (root == null){
             return 0;
         }else{
             int l = minDepth(root.left);
             int r = minDepth(root.right);
             return Math.min(l,r)+1;
         }
    }

    public int minDepth2(TreeNode root) {
        if (root == null)
            return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if (root.left == null && root.right == null)
            return 1;

        if (root.left == null || root.right == null)
            return l+r+1;

        return Math.min(l, r) + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
//        if (root.left == null && root.right == null)
//            return l+r+1;

//        if (root.left == null || root.right == null)
//            return l+r+1;

        return root.left != null && root.right != null ? Math.min(l, r) + 1 : l + r + 1;
    }
}
