package Linked_List.Two_Pointers;

import Linked_List.ListNode;

public class LL141_Linked_List_Cycle {
    /*
    题目：判断链表是否包含环
    思路：双指针
         快慢双指针：两个同学跑步，一个跑得快，一个跑得慢。
                   如果跑直线：快的永远在慢的前面；
                   如果跑圈，快的会出现从慢的后面超车的情况（相遇），
                   此时快的比慢的多跑n圈。
    方法：快慢双指针:
        1. 每当慢指针 slow 前进1步，快指针 fast 就前进2步。
        2. 如果 fast 最终遇到空指针，说明链表中没有环；如果 fast 最终和 slow 相遇，那肯定是 fast 超过了 slow 一圈，说明链表中含有环。
    时间复杂度：O(n)
    空间复杂度：O(1)
    */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }

        return false;
    }
}
