package Binary_Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BT652_Find_Duplicate_Subtrees {
    /*
    题目：找重复子树
    思路：0. 与子树有关，后序遍历
         1. 能描述二叉树的结构和内容：前/中/后序遍历结果
         2. 判断重复：HashMap / HashSet
    */

    List<TreeNode> res = new LinkedList<>();
    HashMap<String, Integer> memo = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    public String traverse(TreeNode node) {
        // 起始情况
        if(node == null) return "#";

        // 遍历
        String left = traverse(node.left);
        String right = traverse(node.right);

        // 后序
        // 用前序遍历结果来唯一描述一颗子树，中序/后序结果均可
        String cur = node.val + "," + left + "," + right;
        // Map.getOrDefault(Object key, V defaultValue)方法的作用是：
        // 当Map中有这个key时，就使用这个key值；如果没有就使用默认值defaultValue。
        // 例：c = Map.getOrDefault(a,b) 如果map中有a，返回a对应的value；如果map中没有a，返回默认值b
        int frequency = memo.getOrDefault(cur, 0);
        if(frequency == 1)
            res.add(node);

        // put不仅可以向map中添加元素，也可以直接当作replace(key, newValue)修改map中的值。
        memo.put(cur, frequency+1);

        return cur;
    }
}
