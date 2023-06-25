package Linked_List.Two_Pointers;

import Linked_List.ListNode;

public class LL19_Remove_Nth_Node_From_End_of_List {
    /*
    题目：单链表的倒数第 k 个节点
    思路：双指针
        1. 先让一个指针 p1 指向链表的头节点 head，然后走 k 步。
           现在的 p1，只要再走 n - k 步，就能走到链表末尾的空指针。
        2. 此时，再用一个指针 p2 指向链表头节点 head。让 p1 和 p2 同时向前走，直到p1走到null为止。
           p1 走到链表末尾的空指针时前进了 N - k 步，p2 也从 head 开始前进了 N - k 步，停留在第 N - k + 1 个节点上，即恰好停链表的倒数第 k 个节点上。
           这样，只遍历了一次链表，就获得了倒数第 k 个节点 p2。
    时间复杂度：O(N)
    */
    public ListNode findNthFromEnd(ListNode head, int n) {
        /*
        双指针，一次遍历找到倒数第n个节点
        */
        ListNode p1 = head;
        ListNode p2 = head;
        // 1. 先让一个指针 p1 指向链表的头节点 head，然后走 k 步。
        for(int i = 1; i <= n; i++){
            p1 = p1.next;
        }

        // 2. 此时，再用一个指针 p2 指向链表头节点 head。让 p1 和 p2 同时向前走，直到p1走到null为止。
        while(p1 != null){
            p1 = p1.next;
            if(p1 == null)  // 由于题目需要，让p2最终指向倒数第(n+1)个节点
                break;
            else
                p2 = p2.next;
        }

        return p2;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // findNthFromEnd()返回的是倒数第(n+1)个节点，
        // 此时如果删除的就是首节点，而首节点前面已经没有节点了，就会出错。
        // 所以在首节点前再加一个虚拟首节点dummy
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = findNthFromEnd(dummy, n);
        p.next = p.next.next;
        return dummy.next;
    }
}
