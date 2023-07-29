package Dynamic_Programming.SubSequence;

import java.util.Arrays;
import java.util.Comparator;

public class DP354_Russian_Doll_Envelopes {
    /*
    题目：俄罗斯套娃信封问题
    方法：动态规划 - 最长递增子序列
    相似题目：300
        与300不同是这题给出的原序列是顺序不确定的，也就是说可以自己随意改变原序列的顺序。
        而LIS算法需要输入的序列顺序是确定的。所以我们需要在使用LIS前，确定原序列的顺序。
        这题的递增原则是w和h全部递增才可以，但排序无法对两个指标同时排序，
        所以需要先确定w的顺序，再确定w相同时的h的顺序。
        当没有什么约束条件时，把w按照升序排序才能得到w的最长递增子序列。
        当w相同时，需要考虑h的排序。这时就有了约束条件（w相等，无法套信封），故简单的把h升序则无法满足条件。
        实际上，当w相同时，不管有多少个h不同的信封，我们最多取其中一个。
        所以我们把h降序排列，这样w相同而h不同的递增子序列就只能有一个元素。

    LIS算法的特点：
        1. 输入的原序列的顺序得是确定的
        2. 如果输入的原序列是升序的，则非常轻松的得到最长递增子序列。
        3. 如果输入的原序列是降序的，则每个递增子序列都只能有一个元素。
    */
    public int maxEnvelopes(int[][] envelopes) {
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });

        // LIS
        // dp数组+初始化, base case
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        for(int i = 0; i < envelopes.length; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[i][1]>envelopes[j][1])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        int res = 0;
        for(int i = 0; i < dp.length; i++){
            res = res > dp[i] ? res : dp[i];
        }
        return res;
    }
}
