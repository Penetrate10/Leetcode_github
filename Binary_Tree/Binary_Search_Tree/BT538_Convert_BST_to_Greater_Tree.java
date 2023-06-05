package Binary_Tree.Binary_Search_Tree;

import Binary_Tree.TreeNode;

public class BT538_Convert_BST_to_Greater_Tree {
    /*
    题目：二叉搜索树变成累加树
    思路：中序遍历二叉搜索树可得到从小到大的遍历结果，倒序使用中序遍历就可以得到从大到小的遍历结果
    */
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    int sum = 0;
    public void traverse(TreeNode node) {
        if(node == null) return;

        // 倒序使用中序遍历
        traverse(node.right);

        // 中序
        sum += node.val;
        node.val = sum;

        // 倒序使用中序遍历
        traverse(node.left);
    }
}
