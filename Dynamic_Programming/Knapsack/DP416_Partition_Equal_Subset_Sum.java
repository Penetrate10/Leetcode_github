package Dynamic_Programming.Knapsack;

public class DP416_Partition_Equal_Subset_Sum {
    /*
    题目：子集背包问题
    思路：= 给一个可装载重量为 sum / 2 的背包和 N 个物品，每个物品的重量为 nums[i]。现在让你装物品，是否存在一种装法，能够恰好将背包装满？
        1. 子问题：可选择前 i 个物品 和 背包容量 j 的组合
           dp数组：dp[i][j] = x 表示，对于前 i 个物品，当前背包的容量为 j 时，若 x 为 true，则说明可以恰好将背包装满，若 x 为 false，则说明不能恰好将背包装满。
        2. 选择：「装进背包」或者「不装进背包」
           状态转移：dp[i][j] 取决于 dp[i-1][j] 和 dp[i][j-nums[i-1]]
        3. base case：第一行第一列
    详见：https://labuladong.github.io/algo/di-er-zhan-a01c6/bei-bao-le-34bd4/jing-dian--43be3/#%E4%B8%80%E3%80%81%E9%97%AE%E9%A2%98%E5%88%86%E6%9E%90
    */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        if(sum % 2 != 0) return false;

        int w = sum/2;  // 计算出背包容积

        boolean[][] dp = new boolean[nums.length+1][w+1];
        // 1. 初始化 base case
        for(int j = 1; j < nums.length+1; j++) {
            dp[j][0] = true;
        }

        // 2. 穷举所有子问题的组合
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                // 3. 选择
                if(j < nums[i-1])  // 背包装不下了
                    dp[i][j] = dp[i-1][j];  // 装不下了 = 不装进背包
                else
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];  // 不装进背包 || 装进背包
            }
        }

        return dp[nums.length][w];
    }
}
