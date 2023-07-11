package Array_String.Two_Pointers.FastSlow_Pointers.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class A76_Minimum_Window_Substring {
    /*
    题目：最小覆盖子串
    思路：经典双指针 -> 滑动窗口
         指针 left 和指针 right 维护了一个窗口 [left, right)。
         其中，指针 left 是主体，right 是探头。
         right 的滑动可以看作给 left 找最小可行解。（right遇到的第一个可行解就是最小可行解，不需要考虑right继续右移产生的其他可行解，因为它们都不是最小可行解）
         left 的滑动可以看作是在优化这个最小可行解。
         为什么left是主体？把所有不在t中的字符去掉后，可以发现 left 实际上是每次右移一个单位，这个过程就可以看作是在以 left 为主体，找所有可行解。
         详见：https://labuladong.gitee.io/algo/di-yi-zhan-da78c/shou-ba-sh-48c1d/wo-xie-le--f7a92/
    */
    public String minWindow(String s, String t) {
        // 用于记录需要的字符和窗口中的字符及其出现的次数
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 统计 t 中各字符出现次数
        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0;
        int len = Integer.MAX_VALUE;
        // 窗口中满足需要的字符个数
        int valid = 0;
        while(right < s.length()){
            // c 是将移入窗口的字符
            char c = s.charAt(right);

            // 进行窗口内数据的一系列更新
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c)))
                    valid++;
            }

            // 扩大窗口
            right++;

            // 判断左侧窗口是否要收缩
            while(left < right && valid == need.size()){
                // d 是将移出窗口的字符
                char d = s.charAt(left);

                // 进行窗口内数据的一系列更新
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d)-1);
                }

                // 更新最小覆盖子串
                if(right - left < len){
                    start = left;
                    len = right - left;
                }

                // 缩小窗口
                left++;
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }
}
