package Linked_List.Reverse;

import Linked_List.ListNode;

public class LL25_Reverse_Nodes_in_k_Group {
    /*
    题目：如何 K 个一组反转链表
    思路：K个一组在链表上前进 + 每前进一次就反转K个节点
         - K个一组在链表上前进：递归前进：因为上一次反转后的尾节点需要连这一次反转后的后节点，即 上一次的尾节点.next = 这一次的头节点，
                                   所以横跨了两次反转，就需要递归的返回值来实现。
         - 每前进一次就反转K个节点：迭代反转K个节点：3指针

        详见：https://labuladong.gitee.io/algo/di-yi-zhan-da78c/shou-ba-sh-8f30d/ru-he-k-ge-d591d/
    */

    // K个一组在链表上前进
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        // 前序
        // 找到k个节点的头和尾
        ListNode start = head;
        ListNode end = head;
        for(int i = 0; i < k; i++){
            if(end == null) return head;
            end = end.next;
        }
        // 反转K个节点
        ListNode newHead = reverse(start, end);

        // 递归 + 后序：上一次反转后的尾节点需要连这一次反转后的后节点
        start.next = reverseKGroup(end, k);

        // 上一次反转后的尾节点需要连这一次反转后的后节点
        return newHead;

    }

    // 迭代反转K个节点
    ListNode reverse(ListNode start, ListNode end) {
        // 3指针
        ListNode pre, cur, nxt;
        pre = null;  // 保存前一个节点
        cur = start;  // 当前操作的节点
        nxt = start;  // 保存后一个节点

        // 迭代
        while(cur != end) {  // 此处end改为null就是反转整个链表
            nxt = cur.next;  // 注意nxt只能在每次迭代的一开始更新
            cur.next = pre;  // 反转
            pre = cur;  // 更新pre
            cur = nxt;  // 更新cur
        }

        // 返回新的头节点
        return pre;
    }
}
