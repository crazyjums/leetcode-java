package middle;

import utils.tree.TreeNode;

public class IsValidBST {
    private long minValue = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {

        if (root==null)return true;
        /**
         *  * 定义上届和下届，二叉搜索树的定义是：
         *      *  - 根节点的左子树小于根节点的值
         *      *  - 根节点的右子树大于根节点的值
         *      *  - 且左右子树都满足该要求
         *         - 二叉搜索树的中序遍历严格递增
         */
        //验证左子树是否是二叉搜索树
        boolean left = isValidBST(root.left);

        //对当前的逻辑进行编辑
        //验证元素是否是从小到大排序
        //minValue表示前一个值

        if (minValue < root.val) minValue = root.val;
        else return false; //如果



        //验证右子树是否是二叉搜索树
        boolean right = isValidBST(root.right);

        //当左右子树都是二叉搜索树时 ，整棵树才是
        return left && right;
    }

    /**
     * 定义上届和下届，二叉搜索树的定义是：
     *  - 根节点的左子树小于根节点的值
     *  - 根节点的右子树大于根节点的值
     *  - 且左右子树都满足该要求
     * @param root
     */
    private void midOrder(TreeNode root,int low,int up){
        if (root==null){
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getBST();
        IsValidBST isValidBST =new IsValidBST();
        boolean res =isValidBST.isValidBST(root);
        System.out.println(res);
    }
}
