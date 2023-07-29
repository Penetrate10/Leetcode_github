package Dynamic_Programming.SubSequence;

public class DP712_Minimum_ASCII_Delete_Sum_for_Two_Strings {
    /*
    题目：最小 ASCII 删除和
    思路：最小 ASCII 删除和 = 最长公共子序列 LCS （1143题）
         但是 base case 要改成符合本题意的。
    详见：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487860&idx=1&sn=f5759ae4f22f966db8ed5a85821edd34&scene=21#wechat_redirect

    注意：获取char的ASCII码值：强制类型转换 `(int) ch` 将字符类型的 char 转换为 int 类型即可。
         加法中直接和int相加就行，会自动转成ASCII码值。
    */
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        // 1. 初始化 Base Case
        for(int j = 1; j < s2.length()+1; j++) {
            dp[0][j] = dp[0][j-1] + s2.charAt(j-1);
        }
        for(int i = 1; i < s1.length()+1; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }

        // 2. 穷举所有子问题的组合
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                // 3. 在可能的选项中做求最值的选择操作
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i-1][j] + s1.charAt(i-1), dp[i][j-1] + s2.charAt(j-1));
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
