package Array_String.Two_Pointers.FastSlow_Pointers.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class A3_Longest_Substring_Without_Repeating_Characters {
    /*
    题目：最长无重复子串
    思路：滑动窗口
         本题的第2个while循环并不是在疑似解中找可行解，而是进入第2个while循环就已经找到了一个可行解，第2个while循环移动left指针是在为找下一个解做准备。
    */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int len = 0;
        while(right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;

            // 遇到重复的就找到了一个解，这个while是在为找下一个解做准备
            while(window.get(c) > 1) {
                char d = s.charAt(left);
                window.put(d, window.get(d)-1);
                left++;
            }
            // 更新这个解
            len = Math.max(len, right-left);
        }
        return len;
    }
}
