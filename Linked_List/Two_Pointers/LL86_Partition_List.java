package Linked_List.Two_Pointers;

import Linked_List.ListNode;

public class LL86_Partition_List {
    /*
    题目：分解单链表
    思路：因为不需要有序，只是把小于x和大于x的分开，所以可以先分成2个链表，再连成一个。
        1. 把链表分成两个链表：小于x 和 大于等于x 【双指针（新建）】
        2. 连接两个链表
    时间复杂度：O(n)
    空间复杂度：O(1)
    */
    public ListNode partition(ListNode head, int x) {
        // 存放小于 x 的链表的虚拟头结点
        ListNode dummy1 = new ListNode(-1);
        // 存放大于等于 x 的链表的虚拟头结点
        ListNode dummy2 = new ListNode(-1);
        // p1, p2 指针操作上述两个链表
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        // p指针操作head
        ListNode p = head;

        // 1. 把链表分成两个链表：小于x 和 大于等于x
        while(p != null){  // 遍历原链表
            if(p.val < x){
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            p = p.next;
        }
        // 别忘了把链表的尾节点.next=null
        p2.next = null;

        // 2. 连接两个链表
        p1.next = dummy2.next;

        return dummy1.next;
    }
}
