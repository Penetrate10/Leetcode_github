package String;

public class S_replace_spaces {
    /*
    题目：替换字符串中所有的 空格 为 %20（剑指offer第五题）
    思路：
        1. 遍历添加 【时间O(n)，空间O(n)】
            可以使用API：string.replace(oldChar, newChar)。
            也可以新建一个字符串。把s转换为char数组，遍历时遇到空格就 +="%20"
        2. 原地添加 【时间O(n)，空间O(1)】
            方法：扩容数组+从后向前双指针 => 原地添加
            (1)遍历s，获取空格的个数
            (2)拓展数组(用StringBuilder) 至 所有空格均替换成%20的长度，然后s->char[]
            (3)从后向前替换空格+双指针：一个指针i指向原字符串最后一个位置，一个指针j指向扩充后的字符串的最后一个位置
                如果i为空格，j、j-1、j-2为%20；(i--；j--；)
                如果i不为空格，j=i；(i--；j--；)
                如果i==j，停止。
           总结：
               为什么要从后向前填充，从前向后填充不行么？
                   从前向后填充就是O(n^2)的算法了，因为每次添加元素都要将添加元素之后的所有元素向后移动。
                   其实很多数组填充类的问题，都可以先预先给数组扩容带填充后的大小，然后在从后向前进行操作。
                   这么做有两个好处：
                   1 不用申请新数组。
                   2 从后向前填充元素，避免了从前向后填充元素时，每次添加元素都要将添加元素之后的所有元素向后移动的问题。
     语法：
        String类：String.replace(old, new)可以把替换s中的old替换为new，old和new均可以是char/String。
                 String类的构造方法中，允许用char[]参数来初始化字符串。
        StringBuilder类：StringBuilder 和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。
                        由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。
                        但在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类。
     */

    // 思路一：遍历添加
    public String replaceSpace1(String s) {
        return s.replace(" ", "%20");
        // return s.replaceAll(" ", "%20");
    }

    public String replaceSpace2(String s) {
        String res = "";
        char[] sc = s.toCharArray();
        for (Character c : sc){
            if (c == ' '){
                res += "%20";
            } else {
                res += c;
            }
        }
        return res;
    }


    // 思路2：扩容数组 + 从后向前双指针 => 原地添加
    public String replaceSpace3(String s) {
        // 如果s为空，直接返回
        // 注意字符串为空可能是 "" 或 null
        if(s == null || s.length() == 0){
            return s;
        }

        // 扩容数组
        StringBuilder s_add = new StringBuilder();
        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) == ' ') {
                s_add.append("  ");
            }
        }

        // 设定双指针
        int i = s.length()-1;  // 左指针：指向原字符串最后一个位置
        s += s_add.toString();
        int j = s.length()-1;  // 右指针：指向扩充后的字符串的最后一个位置
        char[] sc = s.toCharArray();

        while(i != j){  // 设定结束条件，i==j意味着没有空格了
            if (sc[i] == ' '){
                sc[j] = '0';
                sc[j-1] = '2';
                sc[j-2] = '%';
                j = j - 3;
            } else {
                sc[j] = sc[i];
                j--;
            }
            // 不要忘了update pointers
            i--;
        }

        String res = new String(sc);
        return res;
    }


    public static void main(String[] args){
        S_replace_spaces t1 = new S_replace_spaces();
        System.out.println(t1.replaceSpace1("ab c d "));
        System.out.println(t1.replaceSpace2("ab c d "));
        System.out.println(t1.replaceSpace3("ab c d "));
    }
}
