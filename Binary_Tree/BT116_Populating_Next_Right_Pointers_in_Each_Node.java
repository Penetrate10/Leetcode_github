package Binary_Tree;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class BT116_Populating_Next_Right_Pointers_in_Each_Node {
    /*
    思路：相当于在遍历空隙。
         详见https://labuladong.gitee.io/algo/di-yi-zhan-da78c/shou-ba-sh-66994/dong-ge-da-cbce8/#第二题填充节点的右侧指针
    */
    public Node connect(Node root) {
        if(root == null) return null;
        traverse(root.left, root.right);
        return root;
    }

    public void traverse(Node node1, Node node2) {
        if(node1 == null || node2 == null) return;

        // 前序
        node1.next = node2;

        // 遍历三叉树
        // 连接相同父节点的两个子节点
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        // 连接跨越父节点的两个子节点
        traverse(node1.right, node2.left);
    }
}
