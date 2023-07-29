package Dynamic_Programming.SubSequence;

import java.util.Arrays;

public class DP300_Longest_Increasing_Subsequence {
    /*
    题目：最长递增子序列 LIS
    方法：动态规划
    思路：
        0. 明确问题
           状态/子问题：dp[i] 表示以 nums[i] 这个数结尾的 最长递增子序列的长度。
           选项/选择：nums[i]的加入
           状态转移方程：【运用数学归纳法的思想，假设 dp[0...i-1] 都已知，想办法求出 dp[i]，一旦这一步完成，整个题目基本就解决了。
                       但如果无法完成这一步，很可能就是dp数组的定义不够恰当，需要重新定义dp数组的含义；
                       或者可能是dp数组存储的信息还不够，不足以推出下一步的答案，需要把dp数组扩大成二维数组甚至三维数组。】
                       此题为：
                       dp[1]~dp[i-1]代表了每个数作为 以其自身为结尾的 最长递增子序列的长度，也就是说每个数都是 以其自身为结尾的 最长递增子序列的最大值。
                       所以nums[i]作为nums[1...i]的最长递增子序列中的最大值，那么nums[1..i-1]的最长递增子序列的最大值应当小于nums[i]。
                       我们只要找到前面那些结尾比 nums[i] 小的子序列，然后把 nums[i] 接到这些子序列末尾，就可以形成一个新的递增子序列，而且这个新的子序列长度加一。
                       故在满足nums[i-1]<nums[i]的条件下，只需要在dp[1...i-1]中找到最大值即可。
        1. 创建dp数组，并初始化
        2. base case：dp[0] = 1
        3. 状态转移：
            for(穷举所有可能的子问题dp[i]){
                对其中的子问题dp[i] = 求最值(穷举所有可能的选项);
            }
    */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        Arrays.fill(dp, 1);

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[j]+1, dp[i]);
            }
        }

        int res = 0;
        for(int i = 0; i < dp.length; i++){
            res = res > dp[i] ? res : dp[i];
        }
        return res;
    }
}
