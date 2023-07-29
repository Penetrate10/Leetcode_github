package Array_String.Prefix_Sum;

public class A53_Maximum_Subarray {
    /*
    题目：最大连续子数组和
    思路：1. 前缀和
         2. 动态规划之子序列、子数组
         3. 滑动窗口
    详见：https://labuladong.github.io/algo/di-er-zhan-a01c6/zi-xu-lie--6bc09/dong-tai-g-ce18b/
    */

    // 前缀和
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] preSum = new int[nums.length+1];
        preSum[0] = 0;
        // 构造 nums 的前缀和数组
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int res = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 维护 minVal 是 preSum[0..i] 的最小值
            minVal = Math.min(minVal, preSum[i]);
            // 以 nums[i] 结尾的最大子数组和就是 preSum[i+1] - min(preSum[0..i])
            res = Math.max(res, preSum[i + 1] - minVal);
        }
        return res;
    }

    /*
    // 动态规划
    // 1. 子问题 & dp数组定义：在 nums[0..i] 中，符合要求的最大连续子数组和是 dp[i]，子数组必须以 i 指向的内容结尾
    // 2. 选项：前面的最大连续子数组和 要不要加上 nums[i]?
    //         要加上 nums[i]，那么 nums[0..i] 中最大连续子数组以 nums[i] 结尾；
    //         不加上 nums[i]，那么 nums[0..i] 中最大连续子数组以 nums[i] 开头，也以 nums[i] 结尾，只有这一个元素。
    // 3. base case：最小子问题：dp[0] = nums[0]
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] dp = new int[nums.length];
        // 1. 初始化base case
        dp[0] = nums[0];

        // 2. 穷举所有子问题
        for(int i = 1; i < nums.length; i++) {
            // 3. 选择：在所有选项中求最值
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
    */
}
