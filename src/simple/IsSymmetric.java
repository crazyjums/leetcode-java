package simple;

import utils.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {
    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();

        TreeNode root = new TreeNode(2);
        root.setLeft(new TreeNode(4));
        root.setRight(new TreeNode(4));
        TreeNode l = root.getLeft();
        l.setRight(new TreeNode(80));
        l.setLeft(new TreeNode(100));
//        l.getRight().setLeft(new TreeNode(62));
//        l.getRight().setRight(new TreeNode(70));
        TreeNode r = root.getRight();
        r.setLeft(new TreeNode(80));
        r.setRight(new TreeNode(100));
//        r.getLeft().setRight(new TreeNode(58));

        System.out.println(isSymmetric.isSymmetric(root));

    }

    public boolean isSymmetric(TreeNode root) {
        if (null==root ||(null==root.left && null == root.right))
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()){
            /**
             * 先将待比较的左右子树取出
             */
            TreeNode l = queue.poll();
            TreeNode r = queue.poll();

            /**
             * 如果左右都为空，则继续遍历
             *
             */

            if (null == l && null == r){
                continue;
            }

            /**
             * 如果左右其中有一个为空，则返回false
             */
            if (null == l || null == r){
                return false;
            }

            /**
             * 如果左右子树的值不想等，  则返回false
             */
            if (l.val != r.val)
                return false;

            /**
             * 对应添加值，左子树的左子树对应右子树的右子树
             *           左子树的右子树对应右子树的左子树
             */
            queue.add(l.left);
            queue.add(r.right);

            queue.add(l.right);
            queue.add(r.left);
        }
        return true;
    }
}
