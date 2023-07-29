package Dynamic_Programming.SubSequence;

public class DP1143_Longest_Common_Subsequence {
    /*
    题目：最长公共子序列 LCS算法
    思路：dp数组定义：s1[0..i-1] 和 s2[0..j-1] 的 lcs 长度为 dp[i][j]
            目标：s1[0..m-1] 和 s2[0..n-1] 的 lcs 长度，即 dp[m][n]
         base case: dp[0][..] = dp[..][0] = 0
         选项：不要看s1和s2两个字符串，而是要具体到每一个字符，思考每个字符该做什么。
              如果s1[i] == s2[j]，说明这个字符一定在lcs中，lcs长度+1。
              如果s1[i] != s2[j]，说明s1[i]和s2[j]中至少有一个字符不在lcs中，
              即 s1[i] 不在 / s2[j] 不在 / 都不在。
    详见：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487860&idx=1&sn=f5759ae4f22f966db8ed5a85821edd34&scene=21#wechat_redirect
    */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        // 1. 初始化所有 base case
        // 本来就都是0，可以省略初始化步骤

        // 2. 穷举所有子问题的组合
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                // 3. 在可能的选项中做求最值的选择操作
                if(text1.charAt(i-1) == text2.charAt(j-1)){  // 现在 i 和 j 从 1 开始，所以要减一
                    // s1[i-1] 和 s2[j-1] 必然在 lcs 中
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    // s1[i-1] 和 s2[j-1] 至少有一个不在 lcs 中
                    dp[i][j] = max(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    int max(int n1, int n2, int n3) {
        return Math.max(n1, Math.max(n2, n3));
    }
}
