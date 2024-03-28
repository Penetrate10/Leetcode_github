package Binary_Tree;

public class BT104_Maximum_Depth_of_Binary_Tree {
    /*
    题目：给TreeNode root，求二叉树的最大深度
    思路：后序遍历可以自底向上累计二叉树深度，其实也是动态规划思路
    */
    public int maxDepth(TreeNode root) {
        // 终止条件
        if(root == null) {
            return 0;
        }

        // 后序遍历
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // 后序位置
        int height = Math.max(left, right) + 1;

        return height;
    }
}
