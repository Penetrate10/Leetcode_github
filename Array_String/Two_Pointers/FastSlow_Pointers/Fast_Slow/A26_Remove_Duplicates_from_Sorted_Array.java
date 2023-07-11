package Array_String.Two_Pointers.FastSlow_Pointers.Fast_Slow;

public class A26_Remove_Duplicates_from_Sorted_Array {
    /*
    题目：排序数组的原地去重
    思路：经典快慢双指针：
         让慢指针 slow 走在后面，快指针 fast 走在前面探路，找到一个不重复的元素就排在 slow 的后面(即赋值给 nums[slow+1] 的后面一个元素)，并让 slow 前进一步。
         这样，就保证了 nums[0..slow] 都是无重复的元素，当 fast 指针遍历完整个数组 nums 后，nums[0..slow] 就是整个数组去重之后的结果。
    */
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(fast < nums.length){
            if(nums[slow] != nums[fast]){
                nums[slow+1] = nums[fast];
                slow++;
            }
            fast++;
        }
        return ++slow;
    }
}
