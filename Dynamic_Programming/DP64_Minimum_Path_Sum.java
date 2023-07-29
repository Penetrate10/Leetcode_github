package Dynamic_Programming;

public class DP64_Minimum_Path_Sum {
    /*
    题目：最小路径和
    思路：一般来说，让你在二维矩阵中求最优化问题（最大值或者最小值），肯定需要递归 + 备忘录，也就是动态规划技巧。
        1. 子问题：二维数组的索引 i 和 j
           dp数组：从左上角位置 (0, 0) 走到位置 (i, j) 的最小路径和为 dp[i][j]。
        2. 选择：到 grid[i][j] 的最短路径只能从 [i-1][j] 或 [i][j-1] 来
           状态转移：dp[i][j] 取决于 dp[i-1][j] 和 dp[i][j-1]
        3. base case：第一行第一列
    */

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // 1. 初始化 base case
        dp[0][0] = grid[0][0];
        for(int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        // 2. 穷举所有子问题组合
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                // 3. 选择
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
