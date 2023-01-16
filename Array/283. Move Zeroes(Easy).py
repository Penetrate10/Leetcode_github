def moveZeroes(self, nums: List[int]) -> None:
    """
    题目：把数组中的 0 移到末尾
    Do not return anything, modify nums in-place instead.

    双指针（2个指针都是从左开始）：
        1. 一个指针i指向替代别人的元素，一个指针count指向被替代的元素。
        2. 替代别人的元素：i依次为每个非0元素。被替代的元素：从数组开头开始，被替代后指针count+1
        3. （指向被替代的元素的指针）count也是非0元素的个数，故在完成替代后，count后面的数全变为0即可
    """
    count = 0
    for i in range(len(nums)):
        if nums[i] != 0:
            nums[count] = nums[i]
            count += 1

    for j in range(count, len(nums)):
        nums[j] = 0
