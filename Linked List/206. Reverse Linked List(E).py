from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        """
        反转单链表
        """
        pre_node = None
        cur = head
        while cur != None:
            next_node = cur.next
            cur.next = pre_node
            pre_node = cur
            cur = next_node
        return pre_node
