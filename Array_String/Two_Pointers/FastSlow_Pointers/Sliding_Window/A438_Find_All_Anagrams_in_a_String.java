package Array_String.Two_Pointers.FastSlow_Pointers.Sliding_Window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A438_Find_All_Anagrams_in_a_String {
    /*
    题目：找到所有的异位词 -> 找到 S 中所有 P 的排列
    思路：滑动窗口，思路同 567题
    */
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        while(right < s.length()) {
            char c = s.charAt(right);
            if(need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c)))
                    valid++;
            }
            right++;

            // 方法1
            while(right - left == p.length()) {
                if(valid == need.size())
                    res.add(left);

                char d = s.charAt(left);
                if(need.containsKey(d)) {
                    if(window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
                left++;
            }

            /*
            // 方法2
            while(valid == need.size()) {
                if(right - left == p.length())
                    res.add(left);

                char d = s.charAt(left);
                if(need.containsKey(d)) {
                    if(window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
                left++;
            }
            */

        }
        return res;
    }
}
