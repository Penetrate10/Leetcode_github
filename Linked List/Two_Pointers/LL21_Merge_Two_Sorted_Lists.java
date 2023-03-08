package Linked_List.Two_Pointers;

import Linked_List.ListNode;

public class LL21_Merge_Two_Sorted_Lists {
    /*
    题目：合并两个有序链表
    思路：双指针
    */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 创建虚拟头节点dummy
        ListNode dummy = new ListNode(-1);
        // 操作总链表的指针
        ListNode pointer = dummy;
        // 操作list1和list2的指针
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;

        // p1和p2都不为null时
        while(pointer1 != null && pointer2 != null){  // 只能处理p1、p2都不为null的情况
            // 比较 p1 和 p2 两个指针
            if(pointer1.val <= pointer2.val){
                // 将值较小的的节点接到 p 指针
                pointer.next = pointer1;
                // 移动指针
                pointer1 = pointer1.next;
            } else {
                pointer.next = pointer2;
                pointer2 = pointer2.next;
            }
            // 移动指针
            pointer = pointer.next;
        }

        // p2为null时
        if(pointer1 != null)
            pointer.next = pointer1;

        // p1为null时
        if(pointer2 != null)
            pointer.next = pointer2;

        return dummy.next;
    }
}
