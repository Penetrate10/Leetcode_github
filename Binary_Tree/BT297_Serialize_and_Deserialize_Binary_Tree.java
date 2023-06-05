package Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BT297_Serialize_and_Deserialize_Binary_Tree {
    /*
    题目：二叉树的序列化和反序列化
    思路：利用二叉树遍历结果可以生成（反序列化）二叉树，生成时注意找根节点
         详见https://mp.weixin.qq.com/s/DVX2A1ha4xSecEXLxW_UsA
    */

    // 方法1: 前序遍历
    // Encodes a tree to a single string.
    // 前序遍历主函数
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }
    // 前序遍历辅助函数：生成前序遍历结果字符串
    public void traverse(TreeNode node, StringBuilder sb) {
        if(node == null){
            sb.append("#").append(",");
            return;
        }

        // 前序
        sb.append(node.val).append(",");

        // 遍历
        traverse(node.left, sb);
        traverse(node.right, sb);
    }

    // 反序列化主函数
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(",")) {
            nodes.add(s);
        }
        return deserialize(nodes);
    }

    // 反序列化辅助函数：使用构建二叉树框架。方法：每次都是找根结点
    // 原理：只要遍历时处理每个节点的顺序与前序遍历相同，就可以完全还原一棵二叉树。
    public TreeNode deserialize(LinkedList<String> nodes) {
        //if(nodes.size() == 0) return null;

        // 前序
        String s = nodes.removeFirst();
        if(s.equals("#"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));

        // 遍历
        node.left = deserialize(nodes);
        node.right = deserialize(nodes);

        return node;
    }

    /*
    // 方法2: 后序遍历
    // Encodes a tree to a single string.
    // 后序遍历主函数
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }

    // 后序遍历辅助函数：生成后序遍历结果字符串
    public void traverse(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("#").append(",");
            return;
        }

        traverse(node.left, sb);
        traverse(node.right, sb);

        sb.append(node.val).append(",");
    }

    // Decodes your encoded data to tree.
    // 反序列化主函数
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(",")){
            nodes.add(s);
        }
        return deserialize(nodes);
    }

    // 反序列化辅助函数：使用构建二叉树框架。方法：每次都是找根结点
    // 原理：从后向前看后序遍历结果，每一个元素都是根结点
    // 所以如果从后向前处理后序遍历结果，即root+右子树+左子树，就可以使用二叉树构建框架（前序遍历）生成二叉树。
    public TreeNode deserialize(LinkedList<String> nodes) {
        // 前序
        String s = nodes.removeLast();
        if(s.equals("#"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));

        // 遍历（注意顺序，先右子树，后左子树）
        node.right = deserialize(nodes);
        node.left = deserialize(nodes);

        return node;
    }

    // 中序遍历：即使有null，也无法仅通过中序遍历结果还原二叉树，因为无法在中序遍历结果中找到根结点的位置。


    // 层序遍历
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        // 利用Queue的FIFO特点进行层序遍历，Queue里存的是TreeNode
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // 处理节点时，把其子节点加入Queue
        while(q.size()!=0) {
            TreeNode cur = q.poll();
            if(cur == null){
                sb.append("#").append(",");
                continue;
            }
            sb.append(cur.val).append(",");

            q.offer(cur.left);
            q.offer(cur.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        if(nodes[0].equals("#")) return null;

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.offer(root);

        int i = 0;
        while(q.size() != 0) {
            TreeNode cur = q.poll();

            String left = nodes[++i];
            if(left.equals("#")){
                cur.left = null;
            }else{
                cur.left = new TreeNode(Integer.parseInt(left));
                q.offer(cur.left);
            }

            String right = nodes[++i];
            if(right.equals("#")){
                cur.right = null;
            }else{
                cur.right = new TreeNode(Integer.parseInt(right));
                q.offer(cur.right);
            }
        }

        return root;
    }
    */
}
