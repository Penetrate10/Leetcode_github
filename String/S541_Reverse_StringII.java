package String;

public class S541_Reverse_StringII {
    public static String reverseStr(String s, int k) {
        /*
        题目：反转字符串II
        方法：1. 使用StringBuffer类的方法 reverse()
             2. 自己根据异或写一个reverse()，然后用String的toCharArray()方法，
        */

        String res = "";
        // 每2k为一个间隔，提升效率，
        // 所以当需要固定规律一段一段去处理字符串的时候，要想想在在for循环的表达式上做做文章！！！
        for(int i = 0; i<s.length(); i += 2*k){
            int start = i; // 开始
            int firstK = Math.min(start+k, s.length()); // 第1个k
            int secondK = Math.min(start+2*k, s.length()); // 第2个k

            // 用StringBuffer 和 string的substring 获取要反转的字符串
            StringBuffer temp = new StringBuffer(s.substring(start, firstK)); // string.substring()的两个参数是左闭右开
            // 反转
            temp.reverse(); // StringBuffer类的reverse()的两个参数是左闭右开

            // 构建结果字符串
            res += temp.toString();
            // k-2k是否还有字符
            if (secondK > firstK) // 此时k-2k区间一定有字符
                res += s.substring(firstK, secondK);
        }
        return res;
    }

    public static void main(String[] args){
        String t = "abcdefgh";
        int k = 3;
        System.out.println(reverseStr(t, k));
    }
}
