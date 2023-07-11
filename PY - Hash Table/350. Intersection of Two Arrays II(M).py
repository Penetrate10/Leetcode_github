import collections
from typing import List


def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
    """
    题目：求交集（重复的也算次数）
    方法：方法一：set和dic求交集用 & 。
                因为重复算次数，所以用dic
         方法二：sort后用双指针，每个list一个指针
    相似题目：349
    """
    intersection = collections.Counter(nums1)
    intersection &= collections.Counter(nums2)
    res = []
    for i in intersection.keys():
        for j in range(intersection[i]):
            res.append(i)
    return res
