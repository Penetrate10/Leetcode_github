package Dynamic_Programming.SubSequence;

public class DP72_Edit_Distance {
    /*
    题目：最小编辑距离
         详见：https://labuladong.github.io/algo/di-er-zhan-a01c6/zi-xu-lie--6bc09/jing-dian--e5f5e/
    思路：动态规划:
        1. 明确子问题: word1[0,i] 和 word2[0,j] 的最小编辑距离
        2. 明确选项: 插入/删除/替换/什么都不做
        3. 明确dp函数定义：输入i和j，给出word1[0,i] 和 word2[0,j] 的最小编辑距离
            dp数组的定义：dp[i][j] 是 word1[0,i-1] 和 word2[0,j-1] 的最小编辑距离
        4. 状态转移方程：
            if 指针内容相同:
                dp[i][j] = dp[i-1][j-1]  // 什么都不做
            else:
                 dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1;  // 插入/删除/替换
        5. base case：二维数组的base case一般是一行一列。
           这题是 如果 j 走完 s2 时，如果 i 还没走完 s1，那么只能用删除操作把 s1 缩短为 s2；
           如果 i 走完 s1 时 j 还没走完了 s2，那就只能用插入操作把 s2 剩下的字符全部插入 s1。
           这两种情况就是算法的 base case。
    */

    /*
    // 自顶向下
    public int minDistance(String word1, String word2) {
        // 0. 明确子问题，明确状态：i和j这两个指针所代表的 [0..i], [0..j] 这两个字符串
        int i = word1.length()-1;
        int j = word2.length()-1;

        // 3.1 创建并初始化备忘录
        int[][] memo = new int[word1.length()+1][word2.length()+1];
        for(int x = 0; x < memo.length; x++){
            for(int y = 0; y < memo[x].length; y++){
                memo[x][y] = -666;
            }
        }

        // 0. 明确dp函数/dp数组的定义
        return dp(i, j, word1, word2, memo);
    }

    public int dp(int i, int j, String s1, String s2, int[][] memo){
        // 1. 列出base case
        if(i == -1) return j + 1;
        if(j == -1) return i + 1;

        // 3.2 查找备忘录
        if(memo[i][j] != -666) return memo[i][j];

        // 2. 状态转移，做选择
        // 本题无法用for列出每一层的所有可能选项（所有可能状态，所有可能的子问题）
        // 2.1 （利用递归)写出当前子问题的子问题的最优解：共有4种情况，就不每个单独写出来了，直接融入状态转移方程

        if(s1.charAt(i) == s2.charAt(j)){  // 2.3
            memo[i][j] = dp(i-1, j-1, s1, s2, memo);
            return memo[i][j];
        }

        // 2.2 （用状态转移方程）求当前这个子问题的最优解：求最大/小值 -> 做选择
        memo[i][j] = Math.min(dp(i-1, j-1, s1, s2, memo)+1, Math.min(dp(i, j-1, s1, s2, memo)+1, dp(i-1, j, s1, s2, memo)+1));
        return memo[i][j];
    }
    */

    // 自底向上
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        // 1. 初始化 Base Case
        for(int i = 0; i < word2.length()+1; i++) {
            dp[0][i] = i;
        }
        for(int i = 0; i < word1.length()+1; i++) {
            dp[i][0] = i;
        }

        // 2. 穷举所有的子问题组合
        for(int i = 1; i < word1.length()+1; i++) {
            for(int j = 1; j < word2.length()+1; j++) {

                // 3. 在可能的选项中做选择
                if(word1.charAt(i-1) == word2.charAt(j-1)){  // 指针内容相同，啥也不用做
                    dp[i][j] = dp[i-1][j-1];
                } else {  // 指针内容不同，插入/删除/替换
                    // 等号左边是选择后的状态，是下一个状态
                    // 等号右边是选择前状态，写状态转移时看作是当前状态
                    // 这里是双指针在两个String上滑动，需要画图来写状态转移的代码
                    dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    int min(int n1, int n2, int n3) {
        return Math.min(n1, Math.min(n2, n3));
    }
}
