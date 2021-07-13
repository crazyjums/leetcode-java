package utils.tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public static TreeNode getATree(){
        TreeNode root = new TreeNode(2);
        root.setLeft(new TreeNode(4));
        root.setRight(new TreeNode(12));
        TreeNode l = root.getLeft();
        l.setRight(new TreeNode(80));
        l.setLeft(new TreeNode(100));
        l.getRight().setLeft(new TreeNode(62));
        l.getRight().setRight(new TreeNode(70));
        TreeNode r = root.getRight();
        r.setLeft(new TreeNode(50));
        r.setRight(new TreeNode(57));
        r.getLeft().setRight(new TreeNode(58));
        return root;
    }

    public static TreeNode getBST(){
        TreeNode root =new TreeNode(100);
        TreeNode node1 =new TreeNode(45);
        TreeNode node2 =new TreeNode(109);
        TreeNode node3 =new TreeNode(186);
        TreeNode node4 =new TreeNode(10);
        TreeNode node5 =new TreeNode(788);
        TreeNode node6 =new TreeNode(90);

        root.left = node1;
        node1.left = node4;
        node1.right = node6;

        root.right = node3;
        node3.left = node2;
        node3.right = node5;



        return root;

    }

}
