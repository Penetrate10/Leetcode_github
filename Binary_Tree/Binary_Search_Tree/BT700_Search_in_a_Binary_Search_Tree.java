package Binary_Tree.Binary_Search_Tree;

import Binary_Tree.TreeNode;

public class BT700_Search_in_a_Binary_Search_Tree {
    /*
    题目：在BST中做搜索操作
    思路：利用BST的大小关系做类似二分查找
            利用遍历二叉树的递归思想
    */
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;

        if(root.val > val)
            return searchBST(root.left, val);
        else if(root.val < val)
            return searchBST(root.right, val);
        else
            return root;
    }
}
