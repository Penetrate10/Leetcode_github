package Linked_List.Two_Pointers;

import Linked_List.ListNode;

public class LL160_Intersection_of_Two_Linked_Lists {
    /*
    题目：两个链表是否相交
    思路：双指针
        1. 用两个指针 p1 和 p2 分别在两条链表上前进，并不能同时走到公共节点。
           需要通过某些方式，让 p1 和 p2 能够同时到达相交节点。 ->  两链表连起来这样p1和p2可以同时到达
           详见labuladong：
           https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-8f30d/shuang-zhi-0f7cc/#两个链表是否相交
        2. 链表A的尾节点.next = 链表B的头节点，这样如果有公共节点，就会出现环，就可以用 141.判断链表是否包含环 来解决
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2){
            // 如果p1在A上走到头还没遇到公共节点，就连接上B
            p1 = p1 == null ? headB : p1.next;
            // 如果p2在B上走到头还没遇到公共节点，就连接上A
            p2 = p2 == null ? headA : p2.next;
        }

        return p1;
    }
}
