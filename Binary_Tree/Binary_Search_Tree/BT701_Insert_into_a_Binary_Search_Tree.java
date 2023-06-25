package Binary_Tree.Binary_Search_Tree;

import Binary_Tree.TreeNode;

public class BT701_Insert_into_a_Binary_Search_Tree {
    /*
    题目：在 BST 中插入一个数
    思路：在叶子结点插入即可，二叉搜索树不唯一
    */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        if(root.val > val)
            root.left = insertIntoBST(root.left, val);
        else if(root.val < val)
            root.right = insertIntoBST(root.right, val);

        return root;
    }
}
