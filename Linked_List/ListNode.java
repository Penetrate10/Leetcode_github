package Linked_List;

// Definition for singly-linked list.
public class ListNode {
    public int val;  // 结点的值
    public ListNode next;  // 下一个结点

    public ListNode() {  // 节点的构造函数(无参)
    }

    public ListNode(int val) {  // 节点的构造函数(有一个参数)
        this.val = val;
    }

    public ListNode(int val, ListNode next) {  // 节点的构造函数(有两个参数)
        this.val = val;
        this.next = next;
    }
}
