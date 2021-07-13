package simple;

import utils.MyPrintFunction;
import utils.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.pollFirst();
                if (i == size - 1)
                    res.add(t.val);
                if (t.left != null) queue.addLast(t.left);
                if (t.right != null) queue.addLast(t.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getATree();
        MyPrintFunction.levelOrderBinaryTree(root);
        List<Integer> res = new RightSideView().rightSideView(root);
        MyPrintFunction.print(res);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.remove(new Integer(1));
//        list.remove(1);
    }
}
