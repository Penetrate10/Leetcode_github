package Array_String.Two_Pointers.FastSlow_Pointers.Fast_Slow;

public class A283_Move_Zeroes {
    /*
    题目：将数组中的所有值为 0 的元素移到数组末尾
    思路：快慢双指针：同27题
    */
    public void moveZeroes(int[] nums) {
        int n = removeElement(nums, 0);
        for(; n < nums.length; n++){
            nums[n] = 0;
        }
    }

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;

        int slow = 0;
        int fast = 0;
        while(fast < nums.length){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
