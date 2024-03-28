package Binary_Tree;

import java.util.HashMap;

public class BT105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    /*
    题目：通过前序遍历结果和中序遍历结果，构建二叉树
    思路：1.明确前/中/后序遍历结果的区别：
            前序：root + 左子树 + 右子树
            中序：左子树 + root + 右子树
            后序：左子树 + 右子树 + root
        2. 二叉树的构造问题一般都是使用「分解问题」的思路：
            构造整棵树 = 根节点 + 构造左子树 + 构造右子树。
        3. 构造整棵树 -> 构造左、右子树 -> 用递归解决问题：
            每次只考虑如何构造（处理）根节点，其余的交给递归。

    详见：https://labuladong.online/algo/data-structure/binary-tree-part2/#%E9%80%9A%E8%BF%87%E5%89%8D%E5%BA%8F%E5%92%8C%E4%B8%AD%E5%BA%8F%E9%81%8D%E5%8E%86%E7%BB%93%E6%9E%9C%E6%9E%84%E9%80%A0%E4%BA%8C%E5%8F%89%E6%A0%91
    */

    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i = 0; i < inorder.length; i++){
            valToIndex.put(inorder[i], i);
        }

        // 递归起点
        TreeNode root = build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return root;
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd){
        // 终止条件
        if(preStart > preEnd) return null;

        // 构造当前递归的根节点
        TreeNode root = new TreeNode(preorder[preStart]);

        int index = valToIndex.get(preorder[preStart]);
        int leftSize = index - inStart;

        // 递归
        root.left = build(preorder, preStart+1, preStart+leftSize, inorder, inStart, index-1);
        root.right = build(preorder, preStart+leftSize+1, preEnd, inorder, index+1, inEnd);
        return root;
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
