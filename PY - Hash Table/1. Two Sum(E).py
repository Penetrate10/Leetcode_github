from typing import List


def twoSum(self, nums: List[int], target: int) -> List[int]:
    """
    题目：2Sum 两数之和（在array里找元素相加，和为target）
    思路：HashTable
        当需要查询一个元素是否出现过，或者一个元素是否在集合里的时候，就要第一时间想到哈希法。
        本题需要一个集合来存放我们遍历过的元素，然后在遍历数组的时候去询问这个集合，某元素是否遍历过，即是否出现在这个集合。
        那么我们就应该想到使用HashTable了。
        （双指针法可以找到元素，但无法返回元素下标，因为sort过了）
    方法：1. 相加和为target的题目都可以转化为 a = target - b 的形，即用b表示a。（这里的a和b又可以再分）
            这样就可以用Hash Table了。
         2. Hash Table（哈希法）：把遍历得出所有a，存进dict <a的某个值，视情况而定>。遍历得出所有b，看dict中有没有target - b。
    相似题目：454
    """

    # 存放遍历过的元素 <num, index>
    seen = {}
    for i in range(len(nums)):
        # 用差才能把2个元素的问题转化为1个元素的问题，才能使用HashTable的查找功能
        complement = target - nums[i]
        if complement in seen:
            return [seen[complement], i]
        else:
            seen[nums[i]] = i
    return []