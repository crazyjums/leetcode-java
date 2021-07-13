package hard;

import utils.MyPrintFunction;
import utils.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t != null) {
                sb.append(t.val + ",");
                queue.add(t.left);
                queue.add(t.right);
            } else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1); // 删除最后一个逗号
        sb.append("]");
        return sb.toString();
    }
    // Encodes a tree to a single string.


    //    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        if (data == null || data.length() == 0 || data.equals("[]")) return root;
        String sub = data.substring(1, data.length() - 1);
        if (sub.length() == 0) return root;
        String[] vals = sub.split(",");
        root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (!vals[i].equals("null")) {
                t.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(t.left);
            }
            i++;
            if (!vals[i].equals("null")) {
                t.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(t.right);
            }
            i++;
        }

        return root;
    }



    public static void main(String[] args) {
        TreeNode root = TreeNode.getATree();
        MyPrintFunction.levelOrderBinaryTree(root);
        String res = new Codec().serialize(root);
        System.out.println(res);

        TreeNode root2 = new Codec().deserialize(res);
        MyPrintFunction.levelOrderBinaryTree(root2);
    }

}
