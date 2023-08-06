package Dynamic_Programming;

import java.util.HashMap;

public class DP337_House_Robber_Problem_III {
    /*
    题目：打家劫舍问题3
    思路：这题涉及到二叉树，用自底向上的写法不好写。
         1. dp 函数定义：以当前节点为根节点的树的最大获取值。
         2. 选项：当前节点抢/不抢：
                抢：子节点不能再抢，下一个要直接去子子节点；
                不抢：下一个直接去子节点。
    详见：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484800&idx=1&sn=1016975b9e8df0b8f6df996a5fded0af&scene=21#wechat_redirect
    */

    HashMap<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        // base case
        if(root == null) return 0;

        // 备忘录
        if(memo.containsKey(root)) return memo.get(root);

        // 不抢，然后去下层
        int not_do = rob(root.left) + rob(root.right);
        // 抢，然后去下下层
        int do_it = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));

        int res = Math.max(not_do, do_it);

        memo.put(root, res);
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }
