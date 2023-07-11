package Array_String.Two_Pointers.FastSlow_Pointers.Sliding_Window;

import java.util.HashMap;

public class A567_Permutation_in_String {
    /*
    题目：字符串的排列
    思路：寻找子串 -> 滑动窗口
         第一个while循环控制right的滑动，本质上是在找疑似解。什么是疑似解是由第2个while循环的条件定义的。
         第二个while循环控制left的滑动，本质上是在疑似解中找可行解。
         注：疑似解的定义不同可能会产生不同的解法，也就是第2个while循环可能不同。

         详见：https://labuladong.gitee.io/algo/di-yi-zhan-da78c/shou-ba-sh-48c1d/wo-xie-le--f7a92/#%E4%BA%8C%E3%80%81%E5%AD%97%E7%AC%A6%E4%B8%B2%E6%8E%92%E5%88%97
    */
    public boolean checkInclusion(String t, String s) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            // 方法1：把窗口长度==t.length()的看作是疑似解。
            //       这样的疑似解如果包含t中所有的字符，那就直接return true;
            //       如果不包含，就left++，然后right++，相当于窗口右移一位，这样就找到了下一个疑似解。
            while (right - left == t.length()) {
                // 在这里判断是否找到了合法的子串
                if (valid == need.size())
                    return true;
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }

            /*
            // 方法2: 效仿 76. 最小覆盖子串，把包含t中所有的字符的字符串看作是疑似解。
            //       这样的疑似解如果长度和t相同，那就直接return true；
            //       如果长度比t大，那么窗口中有两种可能：
            //       [不符合要求的字符 + 符合要求的字符] 或 [符合要求的字符 + 不符合要求的字符 + 符合要求的字符]
            //       如果是前者，left滑动则可以找到可行解；
            //       如果是后者，那就显然需要舍弃不符合要求的字符，然后从第二段符合要求的字符开始向后寻找疑似解（继续扩大窗口）。
            //       由于这道题中 [left, right) 其实维护的是一个定长的窗口，窗口大小为 t.size()。因为定长窗口每次向前滑动时只会移出一个字符，所以可以把内层的 while 改成 if，效果是一样的。
            while(valid == need.size()){
                if(right - left == t.length())
                    return true;
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d)-1);
                }
            }
            */

        }
        // 未找到符合条件的子串
        return false;
    }
}
