package middle;

import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import utils.tree.TreeNode;

import java.util.Stack;

/**
 * 用非递归的方式实现树的三种深度优先遍历
 */
public class DfsStack {
    public void preOrder2(TreeNode root) {
        if (null == root)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (null != cur || !stack.empty()) {
            while (null != cur) { //先把根和左子树遍历并添加到栈
                System.out.print(cur.val + "  ");
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.empty()) { //当cur没有左子树时，此时需要出栈，进入到右子树的循环中
                cur = stack.pop();
                cur = cur.right;
            }
        }
    }

    public void preOrder(TreeNode root) {
        if (null == root)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            System.out.print(t.val + "  ");
            if (t.right != null) {
                stack.push(t.right);
            }
            if (t.left != null) {
                stack.push(t.left);
            }
        }
        System.out.println();
    }

    public void inOrder(TreeNode root) {
        if (null == root) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            if (!stack.empty()) {
                cur = stack.pop();
                System.out.print(cur.val + "  ");
                cur = cur.right;
            }
        }
        System.out.println();
    }

    /**
     * 此种方法输出的是后序遍历的相反的序列，将其反向即是正确的遍历顺序
     * @param root
     */

    public void afterOrder(TreeNode root) {
        if (null == root)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        while (cur!=null||!stack.isEmpty()) {
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.empty()){
                TreeNode t = stack.pop();
                System.out.print(t.val+"  ");
                cur = cur.right;
            }
        }
        System.out.println();
    }

    public void afterOrder2(TreeNode root) {
        if (null == root)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode lastVisited = null;

        while (null != cur) { //从根节点出发，将该二叉树的所有左子树都放入栈中
            stack.push(cur);
            cur = cur.left;
        }

        while (!stack.empty()) {
            cur = stack.pop();
            if (cur.right == null || lastVisited == cur.right) { //如果当前根节点右子树为空或者右子树被访问过  则输出当前根节点的值
                System.out.print(cur.val + "  ");
                lastVisited = cur;
            } else { //否则，需要遍历右子树
                stack.push(cur); //将当前节点放入栈中，因为还没有被访问
                cur = cur.right; //节点移动到当前节点的右子树上
                while (null!=cur){  // 对右子树做一次相同的事情
                    stack.push(cur);
                    cur =cur.left;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getATree();
        DFS dfs = new DFS();
        DfsStack dfsStack = new DfsStack();
        System.out.println("前序遍历：");
        dfs.preOrderTrversal(root);
        System.out.println();
        dfsStack.preOrder(root);

        System.out.println("中序遍历");
        dfs.midOrderTrversal(root);
        System.out.println();
        dfsStack.inOrder(root);

        System.out.println("后序遍历：");
        dfs.afterOrderTrversal(root);
        System.out.println();
        dfsStack.afterOrder2(root);

    }

}
