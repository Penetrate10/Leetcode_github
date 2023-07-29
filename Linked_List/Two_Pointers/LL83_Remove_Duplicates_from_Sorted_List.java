package Linked_List.Two_Pointers;

import Linked_List.ListNode;

public class LL83_Remove_Duplicates_from_Sorted_List {
    /*
    题目：删除排序链表中的重复元素
    思路：经典快慢双指针，和26题同思路：
         让慢指针 slow 走在后面，快指针 fast 走在前面探路，找到一个不重复的元素就排在 slow 的后面，并让 slow 前进一步。
         这样，就保证了 [0..slow] 都是无重复的元素，当 fast 指针遍历完整个链表后，[0..slow] 就是去重之后的结果。
    */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;

        ListNode slow, fast;
        slow = fast = head;
        while(fast != null){
            if(slow.val != fast.val){
                slow.next = fast;
                slow = fast;
            }
            fast = fast.next;
        }
        slow.next = null;

        return head;
    }
}
