package Binary_Tree;

public class BT114_Flatten_Binary_Tree_to_Linked_List {
    /*
    思路：后序遍历
         虽然题目要求是 前序遍历 的顺序，但是实际上 前/中/后序遍历 到达每个节点的顺序都是一样的，只是处理每个节点的顺序不一样！
         这题一看就需要自底向上展开为链表，所以需要用后序遍历。
    */
    public void flatten(TreeNode root) {
        traverse(root);
    }

    public void traverse(TreeNode node) {
        if(node == null)  // 初始条件不要改
            return;

        traverse(node.left);
        traverse(node.right);

        // 后序
        // 把两个叉都拿下来是最简洁的方法，而不是拿下来右边放到左边上，再把左边整个移到右边。
        // 这是因为会出现null的情况，导致莫名其妙的报错，所以操作指针的方法要尽可能简洁，而不要复杂，可以多弄个指针存储信息。
        TreeNode left = node.left;
        TreeNode right = node.right;

        node.right = left;
        node.left = null;

        TreeNode p = node;
        while(p.right != null){
            p = p.right;
        }
        p.right = right;
    }
}
