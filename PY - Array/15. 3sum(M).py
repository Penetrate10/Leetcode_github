from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:

        '''
        双指针法：（必须排序list）
            思路：最后两个指针用双指针法，其余指针循环遍历，时间复杂度O(n^(k-1))，k是加数的个数。
            1.令i、j、k分别是3个所选数的index， 保证i<j<k。
            2.i在for循环中随着range函数递增。j和k是双指针，从两头向中间移动。
            3.在j和k移动的过程中，如果和比0小，说明j的数小了，j++；
                               如果和比0大，说明k的数大了，k--；
                               如果==0，找到一个解，j++ and k--。
            难点：
            1.去重（相同的三元组）：i和i+1不能相同，j和j+1不能相同，k和k+1不能相同
            2.保证三元组里面能有重复的元素：i和j和可以相同

            时间复杂度：O(n^2)
        '''

        nums.sort()
        res = []
        for i in range(len(nums)):

            # 由于for-range能让i不受 for循环内的i++ 影响，所以只能用if（相同就continue），而不能用while（相同就i++）
            if nums[i] == nums[i - 1] and i > 0:
                continue

            j = i + 1
            k = len(nums) - 1
            while j < k:
                if nums[i] + nums[j] + nums[k] == 0:
                    res.append([nums[i], nums[j], nums[k]])

                    # 找到解后，对j和k去重
                    while j < k and nums[j] == nums[j + 1]:  # python的条件控制语句中，and两侧有顺序之分，“and”左侧要先控制“and”右侧的取值范围
                        j += 1
                    while k > j and nums[k] == nums[k - 1]:
                        k -= 1

                    j += 1
                    k -= 1

                elif nums[i] + nums[j] + nums[k] < 0:
                    j += 1
                elif nums[i] + nums[j] + nums[k] > 0:
                    k -= 1

        return res
