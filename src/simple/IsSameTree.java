package simple;

import utils.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class IsSameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(2);
        p.setLeft(new TreeNode(4));
        p.setRight(new TreeNode(14));
        TreeNode l = p.getLeft();
        l.setRight(new TreeNode(80));
        l.setLeft(new TreeNode(100));
//        l.getRight().setLeft(new TreeNode(62));
//        l.getRight().setRight(new TreeNode(70));
        TreeNode r = p.getRight();
        r.setLeft(new TreeNode(180));
        r.setRight(new TreeNode(1100));

        TreeNode q= new TreeNode();
        q.setLeft(new TreeNode(4));
        q.setRight(new TreeNode(14));
        l = q.getLeft();
        l.setRight(new TreeNode(820));
        l.setLeft(new TreeNode(100));
//        l.getRight().setLeft(new TreeNode(62));
//        l.getRight().setRight(new TreeNode(70));
        r = q.getRight();
        r.setLeft(new TreeNode(180));
        r.setRight(new TreeNode(1100));

        IsSameTree isSameTree = new IsSameTree();
        System.out.println(isSameTree.isSameTree(p,q));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q)
            return true;
        if (null == p && q!=null)
            return false;
        if ((null==q && p!=null))
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (queue.size()>0){
            TreeNode pt = queue.poll();
            TreeNode qt = queue.poll();

            if (null==pt.left && qt.left!=null)
                return false;
            if (null!=pt.left && qt.left==null)
                return false;

            if (null==pt.right && qt.right!=null)
                return false;
            if (null!=pt.right && qt.right==null)
                return false;
            if (pt.val!=qt.val)
                return false;
            if (pt.left != null && qt.left!=null){
                queue.add(pt.left);
                queue.add(qt.left);
            }
            if (pt.right != null && qt.right!=null){
                queue.add(pt.right);
                queue.add(qt.right);
            }
        }
        return true;
    }
}
