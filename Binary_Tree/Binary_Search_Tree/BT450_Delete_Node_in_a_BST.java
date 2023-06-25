package Binary_Tree.Binary_Search_Tree;

import Binary_Tree.TreeNode;

public class BT450_Delete_Node_in_a_BST {
    /*
    题目：删除二叉搜索树中的节点
    思路：1.使用BST框架
         2.详见https://labuladong.gitee.io/algo/di-yi-zhan-da78c/shou-ba-sh-66994/dong-ge-da-7b3e4/#%E4%B8%89%E3%80%81%E5%9C%A8-bst-%E4%B8%AD%E5%88%A0%E9%99%A4%E4%B8%80%E4%B8%AA%E6%95%B0
    */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val == key){
            // 叶子结点（0个子节点）
            if(root.left == null && root.right == null) return null;

            // 只有一个子节点
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            // 有两个子节点
            if(root.left != null && root.right != null){  // 找右子树的最小值/左子树最大值
                // 用右子树最小值替换此节点
                TreeNode minNode = getMinNode(root.right);
                root.val = minNode.val;
                // 转为删除右子树最小值
                root.right = deleteNode(root.right, minNode.val);
            }
        } else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    // 找BST中的最小值
    public TreeNode getMinNode(TreeNode node) {
        // 最左边的最小
        while (node.left != null) node = node.left;
        return node;
    }
}
