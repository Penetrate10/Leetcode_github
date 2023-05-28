package Dynamic_Programming;

import java.util.Arrays;

public class DP322_Coin_Change {
    /*
    题目：凑零钱，求所需最小硬币数
    思路：动态规划：看labuladong动态规划解题套路框架：
        https://labuladong.github.io/algo/di-er-zhan-a01c6/dong-tai-g-a223e/dong-tai-g-1e688/
    【自顶向下递归的动态规划】写代码步骤：
    0. 穷举：
    （1）明确单位问题（「状态」）：凑出比amount小的那些的amount -> 符合最优子结构吗：子问题最优可以推导出原问题最优吗？
    （2）明确选项（「选择」）：导致「状态」产生变化的动作
    （3）明确dp函数/dp数组的定义（结合题目）：输入amount，给出最少硬币数
	其中，状态的个数决定了dp函数有几层for循环，以及dp数组的维数
    （4）明确解空间：是个什么样的多叉树
         列出状态转移方程（结合子问题）（结合动作（选择））：dp(amount) = Math.min(for(amount - coin))
    1. 列出base case
    2. 状态转移
    3. 备忘录
    */
    public int coinChange(int[] coins, int amount) {
        // 3. 对每个“状态”（“子问题”） 创建备忘录，避免重复计算
        int[] memo = new int[amount+1];  // 3.1 创建备忘录
        Arrays.fill(memo, -666);  // 3.2 随便用一个不可能的负数 初始化备忘录

        // 0. 明确子问题，明确dp函数/dp数组的定义
        return dp(amount, coins, memo);
    }

    // 0. 明确子问题，明确dp函数/dp数组的定义
    public int dp(int amount, int[] coins, int[] memo){
        // 1. 列出base case
        if(amount == 0) return 0;

        // 2.2.3 最小的子问题无解的情况
        if(amount < 0) return -1;

        // 3.3 查询备忘录，看这个子问题是否已经计算过了
        if(memo[amount] != -666) return memo[amount];

        // 2. 状态转移
        int res = Integer.MAX_VALUE; // 2.2.2 初始化每一层的最优解（子问题的最优解）

        for(int coin : coins){  // 2.1 穷举每一层的所有可能选项（所有可能状态，所有可能的子问题）
            // 2.2 做选择，求最大/小值
            int temp = dp(amount-coin, coins, memo);  // 2.2.1 （利用递归)写出当前子问题的子问题的最优解

            if(temp == -1) continue;  // 2.2.3 处理子问题的子问题可能无解的情况

            res = Math.min(temp+1, res);  // 2.2.2 （用状态转移方程，结合子问题）求当前这个子问题的最优解：求最大/小值 -> 做选择
        }

        // 3.4 写入备忘录，记录当前这个子问题的最优解
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;

        // 2.2.4 返回子问题的最优解
        return memo[amount];
    }
}
