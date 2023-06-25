package Linked_List.Reverse;

import Linked_List.ListNode;

public class LL92_Reverse_Linked_List_II {
    /*
    题目：反转单链表的一部分
    思路：1. 先递归至要反转的部分，把问题简化成反转前N个节点
         2. 用指针指向第N+1个节点，把问题简化成反转长度为N的整个单链表（leetcode 206）
         详见：https://labuladong.gitee.io/algo/di-yi-zhan-da78c/shou-ba-sh-8f30d/di-gui-mo--10b77/#%E4%B8%89%E3%80%81%E5%8F%8D%E8%BD%AC%E9%93%BE%E8%A1%A8%E7%9A%84%E4%B8%80%E9%83%A8%E5%88%86
    */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        /*
        // 在单链表上通过迭代，前进至left
        ListNode dummy = new ListNode(-1);
        ListNode pointer1 = dummy;
        dummy.next = head;
        for(int i = 1; i < left; i++){
            pointer1 = pointer1.next;
        }

        if(pointer1.next == null) return head;

        ListNode last = reverseN(pointer1.next, right-left+1);

        pointer1.next = last;
        return dummy.next;
        */

        // 在单链表上通过递归，前进至left
        if(left == 1)
            return reverseN(head, right);

        head.next = reverseBetween(head.next, left-1, right-1);

        return head;
    }

    // 记录第N+1个元素地址的指针
    ListNode pointer2 = null;
    // 反转单链表前N个元素
    ListNode reverseN(ListNode head, int n) {
        // 前序
        // 处理起始情况
        if(n == 1){
            pointer2 = head.next;  // 记录第N+1个元素地址
            return head;
        }

        // 递归
        ListNode last = reverseN(head.next, n-1);

        // 后序
        // 处理指针，翻转链表
        head.next.next = head;
        head.next = pointer2;  // 连接第N+1个节点

        return last;
    }
}
