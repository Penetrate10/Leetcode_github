package Array_String.Prefix_Sum;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class A560_Subarray_Sum_Equals_K {
    /*
    题目：找和为k的子数组（子数组在原数组中是由连续元素组成的）
    思路：前缀和（快速、频繁地计算一个索引区间内的元素之和）
         +
         哈希表（存数量，以空间换时间复杂度降低）
    方法：nums[ i..j ] 的累加和 = preSum[ j+1 ] - preSum[ i ]
    来源：https://leetcode.cn/problems/subarray-sum-equals-k/solutions/247577/bao-li-jie-fa-qian-zhui-he-qian-zhui-he-you-hua-ja
    */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumCount = new HashMap<>();

        preSumCount.put(0, 1);

        int preSum = 0;
        int count = 0;
        for(int num : nums){
            preSum += num;

            count += preSumCount.getOrDefault(preSum - k, 0);

            preSumCount.put(preSum, preSumCount.getOrDefault(preSum, 0)+1);
        }

        return count;
    }


    /*
    本题是在数组中找符合要求的子数组，很像滑动窗口，因为滑窗的应用场景是在String中找符合要求的子串。

    这就涉及到滑动窗口的本质：
    - 在String中找符合要求的子串：滑动窗口本身是一个正在拼接的子串，右指针是新增可供拼接的char，左指针是移出已有的char。
    - 在int数组中找符合要求的子数组：滑动窗口本身是一个加法算式，右指针是新增加数，左指针是移出已有的加数。

    但本题中有负数，加负数就是做减法，这与“滑动窗口本身是一个加法算式”相悖。所以不能用滑窗解决。
    */
    public int subarraySum_slide_window(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int left = 0, right = 0;
        int sum = 0;
        int count = 0;

        // sum < k 就用右指针继续添加
        while(left <= right && right < nums.length){
            list.add(nums[right]);
            sum += nums[right];
            right++;

            // sum >= k 就找到了疑似解，就用左指针移出
            while(sum >= k && left < nums.length){
                if(sum == k) count++;

                sum -= list.poll();
                left++;
            }
        }

        return count;
    }
}
