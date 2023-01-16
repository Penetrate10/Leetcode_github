from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        """
        题目：找链表有没有环
        方法：快慢指针 fast&slow runners
             原理：两个同学跑步，一个跑得快，一个跑得慢。
                  如果跑直线：快的永远在慢的前面；
                  如果跑圈，快的会出现从慢的后面超车的情况（相遇），
                  此时快的比慢的多跑n圈。

             1. 设定两个指针 fast 和 slow
             2. fast每次移动2，slow每次移动1
             3. slow进入圈后，在slow跑完一圈的过程中，fast和slow一定会相遇
        """
        # 因为下面有head.next，所以判断一下特殊情况
        if head == None:
            return False

        # initialize the runners（指针）
        slow = head
        fast = head.next

        while fast != None and fast.next != None:  # 如果链表有尾节点，则不含circle
            # 相遇即有circle
            if fast == slow:
                return True
            else:  # 不相遇就更新runners
                fast = fast.next.next
                slow = slow.next

        return False
