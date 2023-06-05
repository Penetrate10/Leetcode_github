package Binary_Tree;

// Definition for a binary tree node.
public class TreeNode {
    public int val;  // Leetcode里面不是public，是默认。但这里方便别的包使用，改成public
    public TreeNode left;  // Leetcode里面不是public，是默认。但这里方便别的包使用，改成public
    public TreeNode right;  // Leetcode里面不是public，是默认。但这里方便别的包使用，改成public
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
