from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        """
        题目：遍历链表
        方法：生成新链表时 从前向后生成节点
        相似题目：445 从后向前生成节点
        """
        # 建立一个虚拟头作为链表的开始
        dummyhead = ListNode(0)
        # 创建指针cur，初始指向链表头
        cur = dummyhead
        # 是否进位
        carry = 0
        # 注意while要带上carry != 0，否则最后一位的进位就丢失了
        while l1 != None or l2 != None or carry != 0:
            # 获取要加的值
            l1_val = l1.val if l1 else 0
            l2_val = l2.val if l2 else 0
            # 计算每一位的和、进位值、这位上显示的数字
            digit_sum = l1_val + l2_val + carry
            carry = digit_sum // 10
            digit = digit_sum % 10
            # 创建下一个节点
            new_node = ListNode(digit)
            # 将当前节点的指针域指向下一个节点
            cur.next = new_node
            # 移动3个指针
            cur = new_node
            if l1:  # if l1 就是 if l1 is not None，None在Python中是一个单例对象、一个特殊的常量
                l1 = l1.next
            if l2:
                l2 = l2.next

        return dummyhead.next
