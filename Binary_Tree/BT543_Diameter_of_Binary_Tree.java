package Binary_Tree;

public class BT543_Diameter_of_Binary_Tree {
    /*
    思路：0. 直径为左右子树最大深度之和。
         1. 涉及到“子树”，考虑使用后序遍历二叉树（来获取子树的信息）。
         2. 注意子问题的定义
    */
    // 使用全局变量记录最大直径
    int maxDia = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);  // 不要返回参数
        return maxDia;
    }

    public int maxDepth(TreeNode node) {
        // 处理初始情况
        if(node == null)
            return 0;

        // 遍历二叉树
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);

        // 后序
        int dia = leftDepth + rightDepth;
        maxDia = dia > maxDia ? dia : maxDia;

        return Math.max(leftDepth, rightDepth) + 1;  // 这个返回值是给父节点看的，所以深度要+1

    }
}
