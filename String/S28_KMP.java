package String;

public class S28_KMP {
    /*
    题目：KMP算法
    思路：1. 计算next数组 O(m)
            【KMP算法之求next数组代码讲解】https://www.bilibili.com/video/BV16X4y137qw?vd_source=96eebad0f253aabd05fde7fdb3c61c92
         2. 使用next数组来匹配 O(n)
            【帮你把KMP算法学个通透！（理论篇）】 https://www.bilibili.com/video/BV1PD4y1o7nd/?share_source=copy_web
    时间复杂度：O(n+m)
    */
    public int strStr(String haystack, String needle) {
        // 先判断特殊情况：needle.length() == 0时，返回0
        if(needle.length() == 0)
            return 0;

        // 1. 获取next数组
        int[] next = getNext(needle);

        // 2. 根据next数组，控制needle上的指针，直到遍历完haystack
        int j = 0;
        for(int i = 0; i < haystack.length(); i++){
            while(j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j-1];
            }
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if(j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;
    }

    public int[] getNext(String needle) {
        /*
        计算next数组
        */
        // 1. j为前缀的指针，初始化为0。前缀不能包含最后一个字符
        int j = 0;

        int[] next = new int[needle.length()];
        next[0] = 0;

        // 从2个字符的子串开始，逐步找各子串的最长相等前后缀
        // i为后缀的指针，初始化为1。后缀不能包含第一个字符
        for(int i = 1; i < needle.length(); i++){

            // 2. 处理前后缀不相同的情况
            /*
            为什么要比needle.charAt(j) 和 needle.charAt(i)是否相等呢？
            因为要看上一步的最长前后缀加上needle.charAt(i)，是否够成新的最长前后缀，
            即 上一步的最长前缀 + needle.charAt(j)  是否等于  上一步的最长后缀 + needle.charAt(i)
            */
            while(j > 0 && needle.charAt(j) != needle.charAt(i)) { // 前后缀不相同了
                j = next[j-1]; // 回退
                /*
                因为next[]是根据子串从短到长得出的，潜在的最长后缀首位是第二个字符，潜在的最长前缀首位是第一个字符，这俩在子串等于2的时候就已经比较了，结果已经在next[]记录了。
                所以next[j-1]已经表明 子串[0, j-1]上的 最长相等前后缀有next[j-1]个字符。
                */
            }

            // 3. 处理前后缀相同的情况
            if(needle.charAt(j) == needle.charAt(i))
                j++;

            // 记录next[i]
            next[i] = j;
        }
        return next;
    }
}
