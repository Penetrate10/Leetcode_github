package Linked_List.Two_Pointers;

import Linked_List.ListNode;
import java.util.PriorityQueue;

public class LL23_Merge_k_Sorted_Lists {
    /*
    题目：合并 k 个有序链表
    思路：最小堆（与 21.合并两个有序链表 的双指针同思路）
    Time complexity: O(nlogk) where k is the number of linked lists.
    Space complexity: O(n)
    */
    public ListNode mergeKLists(ListNode[] lists) {
        // 0. 提前处理特殊情况
        if(lists.length == 0) return null;

        // 1. 创建虚拟头节点，用于开始存结果
        ListNode dummy = new ListNode(-1);
        // 指针p操作上述链表
        ListNode p = dummy;

        // 2. 创建最小堆（用PriorityQueue）
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->{return a.val-b.val;});
        // 3. 初始化最小堆：将 k 个链表的头结点加入最小堆
        for(ListNode head : lists){
            if(head != null)  // pq.add()的元素不能为null
                pq.add(head);
        }

        // 4.利用最小堆，循环poll出当前最小值
        while(pq.size() != 0){
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            p = p.next;
            if(node.next != null)
                pq.add(node.next);
        }
        p.next = null;  // 别忘了尾节点.next=null

        return dummy.next;
    }
}
