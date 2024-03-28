package Array_String.Two_Pointers.LeftRight_Pointers;

public class A581_Shortest_Unsorted_Continuous_Subarray {
    /*
    题目：最短无序连续子数组
    思路：左右双指针 + 线性扫描
    方法：见代码comments
    来源：https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/solutions/912231/gong-shui-san-xie-yi-ti-shuang-jie-shuan-e1le
    */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1;

        // 1. 左右双指针找不单调区间
        //    即此时 [0,l] 和 [r,n) 满足升序要求，而中间部分 [l, r] 无序
        while(left < right && nums[left] <= nums[left+1]) left++;
        while(left < right && nums[right] >= nums[right-1]) right--;
        if(left == right) return 0;

        // 2. 找 不单调区间[l, r] 中的min和max值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = left; i <= right; i++){
            min = nums[i] < min ? nums[i] : min;
            max = nums[i] > max ? nums[i] : max;
        }

        // 3. 检查并缩小 两侧的单调部分，
        //    保证 左侧单调部分[0,l] 中 所有值 < min
        //    保证 右侧单调部分[r,n) 中 所有值 > max
        int i = 0;
        int j = n-1;
        while(i <= left && nums[i] <= min) i++;
        while(j >= right && nums[j] >= max) j--;

        return j-i+1;
    }
}
