package Dynamic_Programming;

public class DP931_Minimum_Falling_Path_Sum {
    /*
    题目：下降路径最小和
    思路：动态规划
    特点：可以优化dp数组：处理每一行时，其实只用到上一行的dp数组，所以只保留上一行和当前行的dp数组即可，无需保存整个（二维）dp数组
    */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        // 1. dp数组
        int[] dp = new int[n];

        // 2. base case + 初始化
        for(int i = 0; i < n; i++){
            dp[i] = matrix[0][i];
        }

        // 3. 穷举：状态转移
        for(int i = 1; i < n; i++){
            int[] current = new int[n];
            for(int j = 0; j < n; j++){
                if(j == 0)
                    current[j] = Math.min(dp[j], dp[j+1]) + matrix[i][j];
                else if(j == n-1)
                    current[j] = Math.min(dp[j-1], dp[j]) + matrix[i][j];
                else
                    current[j] = Math.min(dp[j-1], Math.min(dp[j], dp[j+1])) + matrix[i][j];
            }
            dp = current;
        }


        int res = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            res = res > dp[j] ? dp[j] : res;
        }
        return res;
    }
}
