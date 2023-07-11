from typing import List


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        '''
        最后两个指针用双指针法，其余指针循环遍历，时间复杂度O(n^(k-1))，k是加数的个数。
        与15. 3sum思路相同
        '''
        nums.sort()
        diff = float('inf')  # python中的正无穷
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            
            j = i + 1
            k = len(nums)-1
            while j < k:
                sum = nums[i]+nums[j]+nums[k]

                # 注意diff不要保存成绝对值。在比较时转化成绝对值即可。
                if abs(target - sum) < abs(diff):
                    diff = target - sum

                if sum == target:
                    break
                elif sum < target:
                    j += 1
                elif sum > target:
                    k -= 1
                
            if diff == 0:
                break
        
        return target - diff
