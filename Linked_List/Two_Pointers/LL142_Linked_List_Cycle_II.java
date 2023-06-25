package Linked_List.Two_Pointers;

import Linked_List.ListNode;

public class LL142_Linked_List_Cycle_II {
    /*
    题目：如果链表中含有环，如何计算这个环的起点？
    思路：快慢双指针（是 141.判断链表是否包含环 的进阶题目）
         见labuladong：
         https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-8f30d/shuang-zhi-0f7cc/#判断链表是否包含环
    */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // 判断是否有环
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        if(fast == null || fast.next == null)
            return null;

        // 将两指针的任一个重置为head，两指针速度均为1，相遇即为环的起点
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
