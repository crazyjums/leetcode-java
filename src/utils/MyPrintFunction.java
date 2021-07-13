package utils;

import utils.tree.TreeNode;

import java.util.*;

public class MyPrintFunction {
    public static void print(int[][] a) {
        if (a == null || a.length == 0)
            System.out.println("空数组");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(double[][] a) {
        if (a == null || a.length == 0)
            System.out.println("空数组");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(float[][] a) {
        if (a == null || a.length == 0)
            System.out.println("空数组");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(int[] a) {
        if (a == null || a.length == 0)
            System.out.println("空数组");
        System.out.println(Arrays.toString(a));
    }

    public static void print(char[] a) {
        if (a == null || a.length == 0)
            System.out.println("空数组");
        System.out.println(Arrays.toString(a));
    }

    public static void print(Integer[] a) {
        if (a == null || a.length == 0)
            System.out.println("空数组");
        System.out.println(Arrays.toString(a));
    }

    public static void print(String[] a) {
        if (a == null || a.length == 0)
            System.out.println("空数组");
        System.out.println(Arrays.toString(a));
    }

    public static void print(boolean[] a) {
        if (a == null || a.length == 0)
            System.out.println("空数组");
        System.out.println(Arrays.toString(a));
    }

    public static void print(double[] a) {
        if (a == null || a.length == 0)
            System.out.println("空数组");
        System.out.println(Arrays.toString(a));
    }

    public static void print(float[] a) {
        if (a == null || a.length == 0)
            System.out.println("空数组");
        System.out.println(Arrays.toString(a));
    }

    public static void print(List l) {
        System.out.println(l);
    }

    public static void printSet(Set set) {
        if (!set.isEmpty()) {
            System.out.println(Arrays.toString(set.toArray()));
        }
    }

    public static void print(ListNode root) {
        ListNode cur = root;
        while (null != cur) {
            int t = cur.val;
            cur = cur.next;
            if (cur != null)
                System.out.print(t + "->");
            else
                System.out.print(t);
        }
        System.out.println();
    }


    public static int[] listTo1DArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    private static List<List<Integer>> levelTreeRes = new ArrayList<>();

    private static void _levelOrderBinaryTree(TreeNode root) {
        if (root == null)
            System.out.println("null");
        else {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                List<Integer> a = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    TreeNode t = queue.poll();
                    a.add(t.val);
                    if (t.left != null) queue.add(t.left);
                    if (t.right != null) queue.add(t.right);
                }
                levelTreeRes.add(a);
            }
        }
    }

    public static void levelOrderBinaryTree(TreeNode root) {
        _levelOrderBinaryTree(root);
        System.out.println("层序遍历：" + levelTreeRes);
    }

    private static List<Integer> preTreeRes = new ArrayList<>();
    private static List<Integer> midTreeRes = new ArrayList<>();
    private static List<Integer> postTreeRes = new ArrayList<>();

    private static void _preOrder(TreeNode root) {
        if (root != null) {
            preTreeRes.add(root.val);
            _preOrder(root.left);
            _preOrder(root.right);
        }
    }

    private static void _preOrder2(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                preTreeRes.add(t.val);
                if (t.right != null) stack.add(t.right);
                if (t.left != null) stack.add(t.left);
            }
        }
    }

    private static void _midOrder(TreeNode root) {
        if (root != null) {
            _midOrder(root.left);
            midTreeRes.add(root.val);
            _midOrder(root.right);
        }
    }

    private static void _midOrder2(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                midTreeRes.add(cur.val);
                cur = cur.right;
            }
        }
    }

    private static void _midOrder3(TreeNode root) {
        if (root == null) return;
        TreeNode predecessor;
        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;//predecessor是根节点的左边第一个节点的最右边的一个节点，即当前节点中序遍历结果中的前一个节点
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                //将predecessor的右孩子指向当前的节点
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;//继续遍历当前节点的左子树
                } else {
                    midTreeRes.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            } else { //如果当前节点没有左子树，则表示到了左子树的尽头，或者是最左边的根节点
                midTreeRes.add(root.val);
                root = root.right;
            }
        }
    }

    private static void _postOrder(TreeNode root) {
        if (root != null) {
            _postOrder(root.left);
            _postOrder(root.right);
            postTreeRes.add(root.val);
        }
    }

    private static void _postOrder2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t.left != null) stack.add(t.left);
            if (t.right != null) stack.add(t.right);
            postTreeRes.add(0, t.val);
        }
    }

    public static void preOrder(TreeNode root) {
        _preOrder(root);
        System.out.println("前序遍历：" + preTreeRes);
    }

    public static void midOrder(TreeNode root) {
        _midOrder3(root);
        System.out.println("中序遍历：" + midTreeRes);
    }

    public static void postOrder(TreeNode root) {
        _postOrder2(root);
        System.out.println("后序遍历：" + postTreeRes);
    }

    public static void threeTreeOrders(TreeNode root) {
        preOrder(root);
        midOrder(root);
        postOrder(root);
    }

    public static void main(String[] args) {
        List<List<Double>> a = new ArrayList<>();
        List<Double> b = new ArrayList<>();
        b.add(10.0);
        a.add(b);
        a.add(b);
        print(a);

        TreeNode root = TreeNode.getATree();
//        threeTreeOrders(root);
//        _postOrder(root);
        preOrder(root);
        midOrder(root);
        postOrder(root);
    }


}
