package Bit_Manipulation;

public class BT338_Counting_Bits {

    // 解法1：位运算n & (n-1)
    public int[] countBits(int n) {
        /*
            n = n & (n-1)可以清除 n 的最低位的1
        */
        int[] res = new int[n+1];
        res[0] = 0;

        for(int i = 1; i <= n; i++){
            int num = i;
            while(num != 0){
                num = num & (num-1);
                res[i]++;
            }
        }

        return res;
    }


    // 解法2：观察二进制规律
    public int[] countBits2(int n) {
        /*
        对于所有的数字，只有两类：
            1. 奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
            2. 偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。
                    因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
        来源：https://leetcode.cn/problems/counting-bits/solutions/7882/hen-qing-xi-de-si-lu-by-duadua
        */
        int[] res = new int[n+1];
        res[0] = 0;

        for(int i = 1; i <= n; i++){
            if(i % 2 == 1){
                res[i] = res[i-1] + 1;
            }else{
                res[i] = res[i/2];
            }
        }

        return res;
    }

}
