package Dynamic_Programming.Knapsack;

public class DP518_Coin_Change_II {
    /*
    题目：完全背包问题
    思路：1. dp数组定义：若只使用前 i 个物品（可以重复使用），当背包容量为 j 时，有 dp[i][j] 种方法可以装满背包。
         2. 选择：
            不装入背包：上一个状态应为 只使用前 i-1 个物品有多少种方法能装满容量为 j 的背包，即 dp[i-1][j]。
            装入背包：上一个状态应为 使用前 i 个物品有多少种方法能装满容量为 j-coins[i-1] 的背包，
                    这是因为硬币可以重复使用，之前用没用过 coins[i] 都可以算作上一个状态，所以可以“使用前 i 个物品”。
                    再结合 dp 数组的定义，应为dp[i][j-coins[i-1]]。
         3. 状态转移：dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
    详见：https://labuladong.github.io/algo/di-er-zhan-a01c6/bei-bao-le-34bd4/jing-dian--70de0/
    */
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        // 1. 初始化 base case
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        // 2. 穷举所有子问题的组合
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                // 3. 选择
                if(j < coins[i-1])  // 背包装不下了
                    dp[i][j] = dp[i-1][j];  // 装不下了 = 不装进背包
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];  // 不装进背包 || 装进背包
            }
        }

        return dp[coins.length][amount];
    }
}
