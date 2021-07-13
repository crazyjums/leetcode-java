package secondTime;

import utils.tree.TreeNode;

public class MaxDepth {
    public int maxDepth (TreeNode root) {
        // write code here
        if(root==null)
            return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getATree();
        System.out.println(new MaxDepth().maxDepth(root));
    }
}
