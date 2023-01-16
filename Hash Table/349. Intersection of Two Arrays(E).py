from typing import List


def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
    """
    题目：求并集
    方法：set和dic求并集用 &
         因为不能有重，list和tuple须先用set(list or tuple)转成set，算完再用list()转回。
         （因为交集里重复的只算一次，所以用方法一的set即可）
    Example:
        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        Output: [9,4]
        Explanation: [4,9] is also accepted.
    相似题目：350
    """
    # 方法1：用set
    set_nums = set(nums1)
    set_nums = set_nums & set(nums2)
    return list(set_nums)

    # 方法2：用dic
    '''
    intersection = collections.Counter(nums1)
    intersection &= collections.Counter(nums2)
    return intersection.keys()
    '''
