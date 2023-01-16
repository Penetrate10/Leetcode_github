import collections
from typing import List


def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
    """
    题目：四数之和 II
        【本题是使用哈希法的经典题目，而0015.三数之和，0018.四数之和并不合适使用哈希法，
          因为三数之和和四数之和这两道题目使用哈希法在不超时的情况下做到对结果去重是很困难的，很有多细节需要处理。
          而这道题目是四个独立的数组，只要找到A[i] + B[j] + C[k] + D[l] = 0就可以，
          不用考虑有重复的四个元素相加等于0的情况，所以相对于题目18. 四数之和，题目15.三数之和，还是简单了不少！
        （如果本题想难度升级：就是给出一个数组（而不是四个数组），在这里找出四个元素相加等于0，答案中不可以包含重复的四元组。
          这样就是i和j遍历的同时，k和l双指针。）】
    方法：Hash Table（与1. 2sum相同）
         1. 判断：由于是4个数组，所以i、j、k、j可以相等且没有大小关系，所以可以用简单的方法。
         2. 相加和为target的题目都可以转化为 a = target - b 的形，即用b表示a。
            这里的a和b又可以再分，如a=nums1[i] + nums2[j]，b=nums3[k] + nums4[l]。
            这样就可以用Hash Table了。
         3. Hash Table（哈希法）：把遍历得出所有a，存进dict <a的某个值，视情况而定>。遍历得出所有b，看dict中有没有target - b。
    """

    # 这题统计次数，则可以使用conllections.defaultdict()，可以运行更快
    seen = collections.defaultdict(int)
    count = 0
    # 遍历得出所有i+j，存进dict
    for i in nums1:
        for j in nums2:
            seen[i + j] = seen[i + j] + 1

    # 遍历得出所有k+j，看-(k+j)是否在dict中
    for k in nums3:
        for l in nums4:
            count += seen[-(k + l)]

    return count
