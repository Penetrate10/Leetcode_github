def nextPermutation(self, nums: List[int]) -> None:
    """
    Do not return anything, modify nums in-place instead.
    解析见官方solution，需要看图。
    # 比大小可以在草稿纸上用二维坐标系，这样比列举数字举例子要直观太多。
    """
    i = 0
    for k in range(len(nums) - 1, 0, -1):
        # 从后往前找第一次出现单调递增的index：i
        if k - 1 > 0 and nums[k] > nums[k - 1]:
            i = k - 1
            break

    j = len(nums) - 1
    for k in range(len(nums) - 1, i, -1):
        # 找 大于nums[i]的最小值： nums[j]
        if nums[k] > nums[i]:
            j = k
            break

    if len(nums) > 1:
        self.swap(nums, i, j)  # 交换nums[i]和nums[j]的值
        if nums[j] > nums[j - 1]:  # 特殊情况：整个nums是非严格单调递减的
            self.reverse(nums, i + 1, j - 1)
        else:  # 一般情况
            self.reverse(nums, i + 1, len(nums) - 1)


def swap(self, nums: List[int], i, j) -> None:
    """
    交换两个数的位置
    """

    nums[i], nums[j] = nums[j], nums[i]

    '''
    # 位运算：异或
    nums[i] = nums[i] ^ nums[j]
    nums[j] = nums[i] ^ nums[j]
    nums[i] = nums[i] ^ nums[j]
    '''


def reverse(self, nums: List[int], start, end) -> None:
    '''
    由于本来就是非严格单调递减的，前后双指针指向的值换位就行
    '''
    for i in range(0, int((end - start + 1) / 2)):
        self.swap(nums, start + i, end - i)
