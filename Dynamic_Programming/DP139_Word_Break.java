package Dynamic_Programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DP139_Word_Break {
    /*
    题目：单词拆分
    思路：这题有两种思路：
         以排列组合的视角思考这个问题，就是遍历的思想，是回溯。
         以分解问题的视角思考这个问题，就是动态规划。
         思考一下是否能够把原问题分解成规模更小，结构相同的子问题，然后通过子问题的结果计算原问题的结果。

         对于输入的字符串 s，如果我能够从单词列表 wordDict 中找到一个单词匹配 s 的前缀 s[0..k]，那么只要我能拼出 s[k+1..]，就一定能拼出整个 s。
         换句话说，我把规模较大的原问题 dp(s[0..]) 分解成了规模较小的子问题 dp(s[k+1..])，然后通过子问题的解反推出原问题的解。

         详见：https://labuladong.github.io/algo/di-er-zhan-a01c6/dong-tai-g-a223e/dong-tai-g-f0a05/

         子问题：s[k+1..]
         选项：wordDict 中能够找到匹配 s[k+1..] 的前缀
         dp函数定义：返回 s[i..] 是否能够被拼出
         状态转移方程：当前问题状态 = 子问题状态

    启示：有的子问题可以没有选项，有的子问题可以有多个选项。
    */

    Set<String> wordDict;
    int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = new HashSet<>(wordDict);
        // 备忘录，-1 代表未计算，0 代表无法凑出，1 代表可以凑出
        this.memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s, 0);
    }

    // dp函数定义：返回 s[i..] 是否能够被拼出
    boolean dp(String s, int i) {
        // 1. base case
        if(i == s.length())
            return true;

        // 4. 备忘录防止冗余计算
        if(memo[i] != -1) {
            return memo[i] == 1 ? true : false;
        }

        // 2. 穷举所有子问题
        for(int k = i+1; k <= s.length(); k++) {  // 遍历 s[i..] 的所有前缀。这里是以s的视角穷举，还可以以wordDict的视角，两者都对，但复杂度有所不同。

            // 3. 状态转移：做选择
            String prefix = s.substring(i, k);
            if(wordDict.contains(prefix)){  // 找到每个子问题下的所有选项
                // 找到一个单词匹配 s[i..i+len)
                // 只要 s[i+len..] 可以被拼出，s[i..] 就能被拼出
                boolean subProblem = dp(s, k);
                if(subProblem) {  // 筛选
                    memo[i] = 1;
                    return true;
                }
            }
        }

        // s[i..] 无法被拼出
        memo[i] = 0;
        return false;
    }
}
