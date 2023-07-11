package Array_String.Prefix_Sum;

public class A303_Range_Sum_Query_Immutable {
    /*
    题目：前缀和数组：快速、频繁地计算一个索引区间内的元素之和
    思路：new 一个前缀和数组 preSum 出来，preSum[i] 记录 nums[0..i-1] 的累加和。
         nums[l..r] 的累加和 = preSum[r+1] - preSum[l]
    */

    // 前缀和数组
    private int[] preSum;

    public A303_Range_Sum_Query_Immutable(int[] nums) {
        preSum = new int[nums.length+1];
        preSum[0] = 0;
        // 计算 nums 的前缀和，只用遍历一次数组就可以得到前缀和数组
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {

        return preSum[right+1] - preSum[left];
    }
    class PrefixSum {
        // 前缀和数组
        private int[] preSum;

        /* 输入一个数组，构造前缀和 */
        public PrefixSum(int[] nums) {
            // preSum[0] = 0，便于计算累加和
            preSum = new int[nums.length + 1];
            // 计算 nums 的累加和
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        /* 查询闭区间 [left, right] 的累加和 */
        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }
}
