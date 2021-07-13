package hard;

import utils.MyPrintFunction;
import utils.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CodecTree {
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) return "[]";
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t != null) {
                sb.append(t.val).append(",");
                queue.add(t.left);
                queue.add(t.right);
            } else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);//删除最后的逗号
        sb.append("]");
        return sb.toString();
    }

    public TreeNode deSerialze(String data) {
        TreeNode root = null;
        if (data.length() == 0 || data == "[]") return root;
        //去掉首尾的括号，并用逗号进行分割
        String[] vals = data.substring(1, data.length() - 1).split(",");
        MyPrintFunction.print(vals);
        root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i=1;//对root节点一下的节点进行遍历
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (!vals[i].equals("null")){
                root.left=new TreeNode(Integer.parseInt(vals[i]));
                queue.add(root.left);
            }
            i++;
            if (!vals[i].equals("null")){
                root.right=new TreeNode(Integer.parseInt(vals[i]));
                queue.add(root.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getATree();
//        List<List<Integer>> res = new LevelOrder().levelOrder(root);
        MyPrintFunction.levelOrderBinaryTree(root);
        CodecTree codecTree = new CodecTree();
        String res2 = codecTree.serialize(root);
        TreeNode root2 = codecTree.deSerialze(res2);
        MyPrintFunction.levelOrderBinaryTree(root);



        String s1 = "string";
        String s2 = "string";
        String s3 = new String("string");
        String s4 = new String("string");
        System.out.println(s1==s2);//true
        System.out.println(s3==s4);//false
        System.out.println(s1==s3);//false
        System.out.println(s1==s4);//false
        System.out.println(s1.equals(s4));//true
        System.out.println(s3.equals(s4));//true
        System.out.println(s1.equals(s3));//true


    }
}
