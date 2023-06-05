package Binary_Tree.Binary_Search_Tree;

import Binary_Tree.TreeNode;

public class BT98_Validate_Binary_Search_Tree {
    /*
    题目：判断二叉搜索树BST的合法性
    思路：1. 根据 BST 的定义，node 的整个左子树都要小于 node.val，整个右子树都要大于 node.val。
            所以再结合对BST的观察：一个左子节点最小值继承自其父节点的最小值，最大值是其父节点自身；
                                一个右子节点最小值是其父节点自身，最大值继承自其父节点的最大值。
            需要一个新函数能把 node 自身的约束传递给其左右子树
         2. 涉及到子树，使用后序遍历。但这个函数返回的就是boolean，所以其后序位置代码非常少。
    */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode node, TreeNode min, TreeNode max) {
        // 处理终止情况
        if(node == null) return true;

        // 处理特殊情况
        if(min != null && node.val <= min.val)
            return false;
        if(max != null && node.val >= max.val)
            return false;

        // 后序遍历+后序
        return isValidBST(node.left, min, node) && isValidBST(node.right, node, max);
    }
}
