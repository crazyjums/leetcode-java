package simple;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;
import utils.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSysmetric {
    public static boolean solution(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if (null == left && null == right)
                continue;
            if (null == left || null == right)
                return false;

            if (left.val != right.val)
                return false;

            q.add(left.left);
            q.add(right.right);

            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.setLeft(new TreeNode(4));
        root.setRight(new TreeNode(4));
        TreeNode l = root.getLeft();
        l.setRight(new TreeNode(80));
        l.setLeft(new TreeNode(100));
        TreeNode r = root.getRight();
        r.setLeft(new TreeNode(80));
        r.setRight(new TreeNode(100));
//        r.getLeft().setRight(new TreeNode(58));
        System.out.println(solution(root));
    }
}
