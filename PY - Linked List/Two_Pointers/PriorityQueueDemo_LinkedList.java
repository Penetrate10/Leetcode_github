package Linked_List.Two_Pointers;

import Linked_List.ListNode;
import java.util.PriorityQueue;

public class PriorityQueueDemo_LinkedList {
    /*
    利用 PriorityQueue 对链表元素 构建最小堆/最大堆
     */
    public static void main(String[] args) {
        // 1. 构建一个链表：5-4-3-2-1
        ListNode head = new ListNode(0);
        ListNode p = head;
        for(int i = 5; i > 0; i--){
            p.next = new ListNode(i);
            p = p.next;
        }
        p.next = null;
        p = head.next;
        System.out.print("原链表：");
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();

        // 2. 利用 PriorityQueue 对链表元素 构建最小堆/最大堆
        /*
        lambda表达式格式：(输入参数)->{函数体} （如果函数体只有一句，则 {} 和 ; 可省略。如果函数体只有一句return，则 {} 和 return 和 ; 需一起省略。）
        此处用 lambda函数式编程 指定比较器：
        输入参数：ListNode a和b；
        函数体：规定了比较的方法：
        (a, b)->{return a.val-b.val;} 是最小堆，每次poll出的是当前的最小值。也可写为(a, b)->a.val-b.val
        (a, b)->{return b.val-a.val;} 是最大堆，每次poll出的是当前的最大值。也可写为(a, b)->b.val-a.val
         */
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->{return a.val-b.val;});
        p = head.next;
        while(p != null){
            pq.add(p);  // 插入新元素
            p = p.next;
        }
        System.out.print("PriorityQueue.poll()出的结果：");
        while(pq.size() != 0){
            System.out.print(pq.poll().val + " ");  // poll()获取并移除堆顶元素，如果此时为空，则返回 null。
            // peek()获取但不移除堆顶元素，如果此时为空，则返回 null。
        }
    }
}
