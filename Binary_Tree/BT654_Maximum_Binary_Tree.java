package Binary_Tree;

public class BT654_Maximum_Binary_Tree {
    /*
    题目：构建二叉树
    思路：显而易见的前序遍历。特点在于遍历的方式与一般的前序遍历不同，每次迭代返回的是子树的地址。
    */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length-1);
    }

    public TreeNode build(int[] nums, int low, int high) {
        if(low > high) return null;

        // 前序
        int cur_max = Integer.MIN_VALUE;
        int mid = -1;
        for(int i = low; i <= high; i++){
            if(nums[i] > cur_max){
                cur_max =  nums[i];
                mid = i;
            }
        }
        TreeNode node = new TreeNode(cur_max);

        // 遍历
        node.left = build(nums, low, mid-1);
        node.right = build(nums, mid+1, high);

        return node;
    }
}
