package Linked_List.Reverse;

import Linked_List.ListNode;

public class LL234_Palindrome_Linked_List {
    /*
    题目：判断是否为回文链表
    思路：1. 反转链表，记录链表的反向遍历结果，和正向遍历对比即可
         2. 但这样会重复比较一半的链表，为优化空间复杂度，使用快慢指针先找到中点
         3. 方法1: 因为中点到尾节点可以看作是一整个链表，很好操作（对每个节点操作相同），所以可以使用迭代法把链表后半部分反转，然后再迭代两个链表判断回文。
            方法2: 也可以直接用递归+后序，从后向前遍历链表的后半部分。
            这两种方法时间复杂度一样，但由于递归频繁压栈，实际运行时间和内存都要落后于迭代。
    */

    // 方法1: 迭代法判断是否回文
    public boolean isPalindrome(ListNode head) {
        // 处理特殊情况
        if(head == null || head.next == null) return true;

        // 1. 快慢双指针找到中点
        ListNode slow, fast;
        slow = fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 链表节点数是奇数的情况
        if(fast != null)
            slow = slow.next;

        // 2. 反转后半部分链表
        ListNode newHead = reverse(slow);

        // 3. 判断是否为回文链表
        ListNode left = head;
        ListNode right = newHead;
        while(right != null){  // 只判断一个链表到终点即可，因为两个链表一定是等长的
            if(left.val != right.val)
                return false;

            left = left.next;
            right = right.next;
        }

        return true;
    }

    // 迭代法反转整个单链表
    ListNode reverse(ListNode head) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = nxt = head;

        while(cur != null){
            nxt = nxt.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        return pre;
    }

    // 方法2: 递归判断是否回文
    /*
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        // 处理特殊情况
        if(head == null || head.next == null) return true;

        // 1. 快慢双指针找到中点
        ListNode slow, fast;
        slow = fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 链表节点数是奇数的情况
        if(fast != null)
            slow = slow.next;

        // 2. 利用递归的后序位置，判断是否为回文
        left = head;
        return isP(slow);
    }

    // 递归判断是否回文
    Boolean isP(ListNode node) {
        // 起始情况
        if(node == null) return true;

        // 递归
        Boolean res = isP(node.next);  // 这次不返回新头节点了，返回一个变量让每次递归在后序位置使用

        // 后序
        res = res && (node.val == left.val);
        left = left.next;  // 更新指针

        return res;
    }
    */
}
