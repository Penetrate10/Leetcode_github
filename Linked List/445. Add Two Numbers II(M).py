from typing import Optional


class ListNode:
    # Definition for singly-linked list.
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        """
        题目：遍历链表
        方法：需要先反转链表reverse()，再求和，生成新链表时 可以从后向前生成节点
        相似题目：2 从前向后生成节点
        """
        l1 = self.reverse(l1)
        l2 = self.reverse(l2)
        # 生成头节点head，其实是指针
        head = None
        carry = 0
        while l1 != None or l2 != None or carry != 0:
            if l1:
                l1Val = l1.val
                l1 = l1.next
            else:
                l1Val = 0

            if l2:
                l2Val = l2.val
                l2 = l2.next
            else:
                l2Val = 0

            digitSum = l1Val + l2Val + carry
            carry = digitSum // 10
            digit = digitSum % 10
            # 生成head的前一个节点
            newNode = ListNode(digit)
            newNode.next = head
            # 移动指针
            head = newNode

        return head

    def reverse(self, l: Optional[ListNode]) -> Optional[ListNode]:
        """
        反转链表，做法同206题
        """
        # 创建指针，存储上一个node的地址
        previousNode = None

        while l != None:  # 判断当前节点不是None
            # 创建指针，存储下一个node的地址
            nextNode = l.next
            # 把当前node的指针域改为上一个node
            l.next = previousNode
            # 移动指针
            previousNode = l
            l = nextNode

        return previousNode
