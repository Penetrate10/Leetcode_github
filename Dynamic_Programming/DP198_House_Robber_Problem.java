package Dynamic_Programming;

public class DP198_House_Robber_Problem {
    /*
    题目：打家劫舍1
    思路：动态规划
        1. dp函数/数组定义： nums[0..i] 能抢到的最大值
        2. 选项：抢不抢 nums[i]
        3. 注意这样定义dp数组会出现 i-2 ，所以 base case 要有 dp[0] 和 dp[1] 两个。
    详见：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484800&idx=1&sn=1016975b9e8df0b8f6df996a5fded0af&scene=21#wechat_redirect
    */

    /*
    // 自顶向下
    private int[] memo;
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, nums.length-1);
    }

    public int dp(int[] nums, int i) {
        if(i == 0) return nums[0];
        if(i == 1) return Math.max(nums[0], nums[1]);

        if(memo[i] != -1) return memo[i];

        int res = Math.max(dp(nums, i-2) + nums[i], dp(nums, i-1));
        memo[i] = res;

        return res;
    }
    */

    // 自底向上
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
        }

        return dp[nums.length];
    }
}
