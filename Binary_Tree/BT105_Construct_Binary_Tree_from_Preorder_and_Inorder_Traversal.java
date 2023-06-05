package Binary_Tree;

public class BT105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    /*
    题目：通过前序遍历结果和中序遍历结果，构建二叉树
    思路：明确前/中/后序遍历结果的区别：
            前序：root + 左子树 + 右子树
            中序：左子树 + root + 右子树
            后序：左子树 + 右子树 + root
    */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1,
                     inorder, 0, inorder.length-1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd) {
        // 终止情况
        if(preStart > preEnd) return null;

        // 前序
        int node_val = preorder[preStart];
        int count = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] != node_val)
                count++;
            else  // 找到后，及时中止计数器
                break;
        }
        TreeNode node = new TreeNode(node_val);

        // 遍历
        node.left = build(preorder, preStart+1, preStart+count,
                          inorder, inStart, inStart+count-1);
        node.right = build(preorder, preStart+count+1, preEnd,
                           inorder, inStart+count+1, inEnd);

        return node;
    }

    // For test
    public static void main(String[] args){
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};

        BT105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal t = new BT105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
        TreeNode root = t.buildTree(pre, in);
        printnode(root);
    }

    public static void printnode(TreeNode node) {
        if(node != null)
            System.out.print(node.val + " ");
        else{
            System.out.print("null" + " ");
            return;
        }

        printnode(node.left);
        printnode(node.right);
    }
}
