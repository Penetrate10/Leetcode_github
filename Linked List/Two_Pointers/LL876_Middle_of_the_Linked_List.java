package Linked_List.Two_Pointers;

import Linked_List.ListNode;

public class LL876_Middle_of_the_Linked_List {
    /*
    题目：单链表的中点
    思路：双指针：
        快慢指针：每当慢指针 slow 前进一步，快指针 fast 就前进两步，这样，当 fast 走到链表末尾时，slow 就指向了链表中点。
    */
    public ListNode middleNode(ListNode head) {
        // 快指针
        ListNode fast = head;
        // 慢指针
        ListNode slow = head;

        while(fast != null && fast.next != null){ // 快指针走到尾时，慢指针在中点
            // 慢指针一次走一步
            slow = slow.next;
            // 快指针一次走两步
            fast = fast.next.next;
        }

        return slow;
    }
}
