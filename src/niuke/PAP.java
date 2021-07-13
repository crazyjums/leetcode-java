package niuke;

import utils.ListNode;
import utils.tree.TreeNode;
import java.util.Scanner;

public class PAP {
    public static void preOrder(TreeNode root){
        if(root!=null){
            System.out.print(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String [] argv){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] ns = line.split(" ");
        int n = Integer.parseInt(ns[0]);
        int rv = Integer.parseInt(ns[1]);
        TreeNode root = new TreeNode(rv);
        for (int i = 0; i < n; i++) {
            String _value = sc.nextLine();
            String _values[] = _value.split(" ");

        }

        preOrder(root);
        System.out.println();
    }
}
