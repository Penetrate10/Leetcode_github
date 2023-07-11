from typing import List


def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
    '''
    最后两个指针用双指针法，其余指针循环遍历，时间复杂度O(n^(k-1))，k是加数的个数。
    思路同2sum、3sum（双指针），时间复杂度：O(n^3)
    '''
    nums.sort()
    res = []
    for a in range(len(nums) - 3):
        if a > 0 and nums[a] == nums[a - 1]:
            continue

        for b in range(a + 1, len(nums) - 2):
            if b - a > 1 and nums[b] == nums[b - 1]:
                continue

            c = b + 1
            d = len(nums) - 1
            while c < d:
                sum = nums[a] + nums[b] + nums[c] + nums[d]
                if sum < target:
                    c += 1
                elif sum > target:
                    d -= 1
                elif sum == target:
                    res.append([nums[a], nums[b], nums[c], nums[d]])
                    while c < d and nums[c] == nums[c + 1]:
                        c += 1
                    while c < d and nums[d] == nums[d - 1]:
                        d -= 1

                    c += 1
                    d -= 1

    return res