package Linked_List.Reverse;

import Linked_List.ListNode;

public class LL206_Reverse_Linked_List_I {
    /*
    题目：翻转单链表
    思路：使用递归方法：利用栈后进先出的特性，方便从后向前操作单链表
         递归 + 后序位置写逻辑 = 从后向前操作单链表
         详见：https://labuladong.gitee.io/algo/di-yi-zhan-da78c/shou-ba-sh-8f30d/di-gui-mo--10b77/#%E4%B8%80%E3%80%81%E9%80%92%E5%BD%92%E5%8F%8D%E8%BD%AC%E6%95%B4%E4%B8%AA%E9%93%BE%E8%A1%A8
    */
    public ListNode reverseList(ListNode head) {
        // 前序
        // 处理起始情况
        if(head == null || head.next == null)
            return head;

        // 递归
        // 用返回值记录反转后的新头节点last
        ListNode last = reverseList(head.next);

        // 后序
        // 处理head.next的指针 和 head的指针
        head.next.next = head;
        head.next = null;

        // 传递反转后的新头节点last
        return last;
    }
}
