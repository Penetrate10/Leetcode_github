from typing import List


class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        题目：反转字符串（In-Place）
        方法：1. Recursion, In-Place, O(N)Space
                - Does in-place mean constant space complexity?
                  No. By definition, an in-place algorithm is an algorithm which transforms input using no auxiliary(辅助的) data structure.
                - The tricky part is that space is used by many actors, not only by data structures. The classical example is to use recursive function without any auxiliary data structures.
                  Recursion:
                    Is it in-place? Yes.
                    Is it constant space? No, because of recursion stack.
             2. 双指针，Iteration, O(1)Space
             3. python-api：string.reverse()
        """

        # 方法1：Recursion, In-Place, O(N)Space
        '''
        def helper(left, right):
            if left < right:
                s[left], s[right] = s[right], s[left]
                helper(left + 1, right - 1)

        helper(0, len(s) - 1)
        '''

        # 方法2：Two Pointers, Iteration, O(1)Space
        left, right = 0, len(s) - 1
        while left < right:
            s[left], s[right] = s[right], s[left]
            left += 1
            right -= 1

        # 方法3：python-api
        '''
        s.reverse()
        '''