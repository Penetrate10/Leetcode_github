def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
    '''
    题目：找出数组中最长的连续1
    '''
    max_count = 0
    cur = 0
    for num in nums:
        if num == 1:
            cur += 1
        else:
            max_count = max(max_count, cur)
            cur = 0
    return max(max_count, cur)