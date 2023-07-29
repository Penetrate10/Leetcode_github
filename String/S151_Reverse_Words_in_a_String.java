package String;

public class S151_Reverse_Words_in_a_String {
    /*
    思路：0. java的String不可变，所以不可能原地完成更改。需要借助可以更改的数据结构，StringBuilder / Array。
         1. 先把整个字符串反转
         2. 再把每个单词反转
    方法：1. 直接使用String的trim()去除空格 和 StringBuilder的reverse()反转。
         2. 自己写去除空格和反转的函数。【左右双指针】
    */

    /* 主函数 */
    public String reverseWords(String s) {
        StringBuilder sb;
        sb = trim(s);  // 可以使用s.trim()
        reverseWholeString(sb);  // 可以使用sb.reverse()
        reverseEachWord(sb);
        return sb.toString();
    }

    /* 去除头尾的空格和中间的连续空格 */
    StringBuilder trim(String s) {
        StringBuilder sb = new StringBuilder();

        // 左右双指针
        int start = 0;
        int end = s.length() - 1;

        // 去除头尾的空格
        while(start <= end && s.charAt(start) == ' ') start++;
        while(start <= end && s.charAt(end) == ' ') end--;

        // 去除中间的连续空格
        while(start <= end) {
            if(s.charAt(start) != ' ' || sb.charAt(sb.length()-1) != ' ')
                sb.append(s.charAt(start));
            start++;
        }

        return sb;
    }

    /* 反转整个StringBuiler */
    void reverseWholeString(StringBuilder sb) {
        int left = 0;
        int right = sb.length()-1;
        while(left < right) {
            char c = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, c);
            left++;
            right--;
        }
    }

    /* 反转一个单词 */
    void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 0;

        while(start < sb.length()) {  // 控制start前进
            // 先找到这个单词的结尾
            while(end < sb.length() && sb.charAt(end) != ' ') end++;  // 控制end前进，来找单词结尾

            int p = end + 1;  // 辅助变量记录end的位置（下个单词的start）
            end--;

            // 反转这个单词
            while(start < end) {
                char c = sb.charAt(start);
                sb.setCharAt(start, sb.charAt(end));
                sb.setCharAt(end, c);
                start++;
                end--;
            }

            // 更新下个单词的start和end
            start = end = p;
        }
    }
}
