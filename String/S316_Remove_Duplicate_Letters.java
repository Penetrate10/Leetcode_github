package String;

import java.util.Stack;

public class S316_Remove_Duplicate_Letters {
    /*
    也收录在Array_String -> 双指针 -> 快慢指针 -> Fast_Slow 文件夹中，便于和其他去重题比较。
    题目：无序String去除重复字母
         给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
         和1081是一道题。
         要求1: 要去重。
         要求2: 去重字符串中的字符顺序不能打乱s中字符出现的相对顺序。
         要求3: 在所有符合上一条要求的去重字符串中，字典序最小的作为最终结果。

    思路：1. 原String无序，所以不能用快慢双指针了。那去重就需要一个哈希集合。
         2. 常见的哈希集合无序，但我们要求有序，所以只能用 Stack + boolean[] 来模拟一个有序的哈希集合。
         3. 要字典序最小的，就需要再用一个辅助变量 count[] 来记录该字符剩下的没处理的个数，如果是最后一个了，就不能出栈了。
    */
    public String removeDuplicateLetters(String s) {
        // Stack + boolean[] 来模拟一个有序的哈希集合
        Stack<Character> stk = new Stack<>();
        boolean[] isStack = new boolean[26];
        // 记录该字符剩下的没处理的个数
        int[] count = new int[26];

        // 初始化count
        for(char c : s.toCharArray()) {
            count[c-'a']++;
        }

        for(char c : s.toCharArray()) {
            // 每遍历过一个字符，都将对应的计数减一
            count[c-'a']--;
            if(isStack[c-'a']) continue;
            // 比较已入栈的 和 新入栈的 的字典序
            while(!stk.isEmpty() && stk.peek() > c) {
                if(count[stk.peek()-'a'] > 0){  // 剩下的没处理的字符中，还有该字符
                    isStack[stk.pop()-'a'] = false;  // 出栈
                }else{  // 剩下的没处理的字符中，没有该字符了
                    break;  // 那就必须保留该字符
                }
            }
            // 新字符入栈
            stk.push(c);
            isStack[c-'a'] = true;
        }

        // Stack是倒序的，为了在反转回来，需要用StringBuilder的reverse()
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}
