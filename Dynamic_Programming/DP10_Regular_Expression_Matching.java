package Dynamic_Programming;

public class DP10_Regular_Expression_Matching {
    /*
    题目：正则通配符匹配
    思路：要匹配两种符号：
         '.'好匹配，无脑匹配就完事了。
         '*'不好实现，一旦遇到*通配符，前面的那个字符可以选择重复一次，可以重复多次，也可以一次都不出现。对于这些可能出现的情况，只能全部穷举一遍，那么一旦涉及多种情况的穷举，就应该想到动态规划。上述几种情况也正是动态规划的选项。

    方法：
        一、自底向上：我这种写法只能过79%的测试用例，会有一些特殊情况、特殊边界的测试用例过不了，这时用自顶向下比较方便处理这些特殊情况。
         1. dp 数组：boolean dp[i][j] = s[0..i] 和 p[0..j] 能否匹配得上
         2. 选项：匹配上了 -> 如果 j+1 是 * ，那 j 可能用 0 次 或 多次
                        -> 如果 j+1 不是 * ，正常匹配
                没匹配上 -> 如果 j+1 是 * ，那 j 可能用 0 次
                        -> 如果 j+1 不是 * ，匹配失败
         3. base case：当 p 长度为 0 时，只要 s 长度不为 0，就是false
                       当 s 度为 0 时，如果 p 是 a*b* 这样的形式，那就是true，否则是false

        二、自顶向下：
            详见：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247486742&idx=1&sn=73d38d4d8b51af81b782c6d11fa5e21e&scene=21#wechat_redirect

    总结：1. 两个字符串的题，如果字符串中可能出现多种情况，就应该想到动态规划。上述几种情况也正是动态规划的选项，需要在“选择”中都列举出来。
         2. 当题目比较复杂，如：状态转移中，等号左侧的状态 和 等号右边的状态 在dp数组中不连着时；可能出现特殊情况、特殊边界较多，难以处理时，
            应考虑使用 自顶向下 的写法，
            因为自底向上处理索引越界、特殊情况、特殊边界时 都需要在for循环中处理，而自顶向下可以单独处理。
    */

    // 自底向上
    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int j = 1; j < p.length()+1; j+=2) {
            if(j < p.length() && p.charAt(j) == '*')
                dp[0][j] = true;
        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    if(j < p.length() && p.charAt(j) == '*'){
                        if(j - 2 < 0)
                            dp[i][j] = dp[i-1][j];
                        else
                            dp[i][j] = dp[i][j-2] || dp[i-1][j];
                    } else {
                        dp[i][j] = dp[i-1][j-1];
                    }
                } else {
                    if(j < p.length() && p.charAt(j) == '*'){
                        if(j-2 < 0)
                            dp[i][j] = false;
                        else
                            dp[i][j] = dp[i-1][j-2];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }

        if(p.charAt(p.length()-1) == '*')
            return dp[s.length()][p.length()-1];
        return dp[s.length()][p.length()];
    }

}
