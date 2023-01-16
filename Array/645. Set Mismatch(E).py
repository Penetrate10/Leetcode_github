def findErrorNums(self, nums: List[int]) -> List[int]:
    """
    题目：一个数组元素在 [1, n] 之间，其中一个数被替换为另一个数，找出重复的数和丢失的数
    方法1: 字典 （时间O(n)，空间O(n))
          统计出现的次数
    方法2: 取反 （时间O(n)，空间O(1))
          1. 一个数取反1次是相反数，取反2次还是它自己。
          2. 如何利用上述性质？用重复的数当作index，则由于重复就会出现对同一个元素取反2次的情况。
             即对nums[nums[i]]取反。
    """

    # 方法1：字典
    '''
    dic = {}
    dup = 0
    mis = 0
    for i in range(len(nums)):
        dic[i+1] = 0
    for num in nums:
        dic[num] += 1
    for key in dic:
        if dic[key] > 1:
            dup = key
        elif dic[key] < 1:
            mis = key
    res = [dup, mis]
    return res
    '''

    # 方法2: 取反
    dup = 0
    mis = 0
    for num in nums:  # 找重复的数
        if nums[abs(num) - 1] > 0:
            nums[abs(num) - 1] *= -1
        else:
            dup = abs(num)

    for i in range(len(nums)):  # 找缺失的数
        if nums[i] > 0:
            mis = i + 1

    return [dup, mis]
