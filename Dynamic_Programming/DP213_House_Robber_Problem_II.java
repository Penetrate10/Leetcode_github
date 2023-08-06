package Dynamic_Programming;

public class DP213_House_Robber_Problem_II {
    /*
    题目：打家劫舍问题2
    思路：环形数组 -> 首尾只能要一个 -> 只可能有三种不同情况：要么都不被抢；要么首被抢 尾不抢；要么尾被抢 首不抢。
         后两种情况都包含第一种情况，所以比较后两种情况的结果即可。
         需要在穷举子问题的时候，在 for 循环中 用 i 的取值范围控制是否可以取到 首/尾，这同时也就意味着需要两次独立的for循环分别计算两种情况。
         由于两种情况的起始子问题不同，也就是base case不同，所以整个 dp 数组都不同，要有两个独立的 dp 数组。
         1. dp 数组定义：dp[i] = nums[0..i]能抢到的最大值。
         2. 选项：抢不抢 nums[i]
         3. 注意分析两种情况不同的 base case

         详见：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484800&idx=1&sn=1016975b9e8df0b8f6df996a5fded0af&scene=21#wechat_redirect
    */

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        /* 首被抢 尾不抢 */
        int[] dp = new int[nums.length+1];
        // base case 1
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i = 2; i < dp.length-1; i++) {  // 用i的取值范围控制是否可以取到首尾
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }

        /* 尾被抢 首不抢 */
        int[] dp2 = new int[nums.length+1];
        // base case 2
        dp2[0] = 0;
        dp2[1] = 0;
        dp2[2] = nums[1];

        for(int i = 3; i < dp2.length; i++) {  // 用i的取值范围控制是否可以取到首尾
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+nums[i-1]);
        }

        return Math.max(dp[nums.length-1], dp2[nums.length]);
    }


    // 优化 dp 数组后，空间复杂度O(1)
    /*
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        // base case 1
        int dp_i_2 = 0;
        int dp_i_1 = nums[0];

        for(int i = 1; i < nums.length-1; i++) {
            int dp_i = Math.max(dp_i_1, dp_i_2 + nums[i]);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }

        // base case 2
        int dp2_i_2 = 0;
        int dp2_i_1 = nums[1];

        for(int i = 2; i < nums.length; i++) {
            int dp2_i = Math.max(dp2_i_1, dp2_i_2+nums[i]);
            dp2_i_2 = dp2_i_1;
            dp2_i_1 = dp2_i;
        }

        return Math.max(dp_i_1 , dp2_i_1);
    }
    */
}
