package Array_String.Difference_Array;

public class A370_Range_Addition {
    /*
    题目：区间加法
    思路：频繁对原始数组的某个区间的元素进行增减 -> 经典差分数组
         给一堆数字全加一个数，它们之间的差不变。
         构建差分数组，改变差分数组的一个元素做加减操作，相当于给这个元素及其后面的所有元素都做了相同的操作，O(n) -> O(1)
    */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];

        Difference df = new Difference(arr);

        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int val = updates[i][2];
            df.increment(start, end, val);
        }

        return df.result();
    }
}

// 差分数组工具类
class Difference {
    // 差分数组
    private int[] diff;

    /* 输入一个初始数组，区间操作将在这个数组上进行 */
    public Difference(int[] nums) {
        assert nums.length > 0;
        diff = new int[nums.length];
        // 根据初始数组构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i-1];
        }
    }

    /* 给闭区间 [start, end] 增加 val（可以是负数）*/
    public void increment(int start, int end, int val) {
        diff[start] += val;
        if (end + 1 < diff.length) {
            diff[end+1] -= val;
        }
    }

    /* 返回结果数组 */
    public int[] result() {
        int[] res = new int[diff.length];
        // 根据差分数组构造结果数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}