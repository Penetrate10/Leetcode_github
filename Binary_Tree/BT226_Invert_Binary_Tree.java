package Binary_Tree;

public class BT226_Invert_Binary_Tree {
    /*
    题目：翻转二叉树
    思路：最基础的二叉树题目
         （对前后序不敏感）
    */
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    public void traverse(TreeNode node) {
        // 终结/初始情况处理
        if(node == null) return;

        // 前序
        // 交换左右节点即可
        TreeNode right = node.right;
        node.right = node.left;
        node.left = right;

        // 遍历
        traverse(node.left);
        traverse(node.right);
    }
}
