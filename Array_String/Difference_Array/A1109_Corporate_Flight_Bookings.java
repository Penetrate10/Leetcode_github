package Array_String.Difference_Array;

public class A1109_Corporate_Flight_Bookings {
    /*
    题目：差分数组
    思路：频繁对原始数组的某个区间的元素进行增减 -> 经典差分数组
         给一堆数字全加一个数，它们之间的差不变。
         构建差分数组，改变差分数组的一个元素做加减操作，相当于给这个元素及其后面的所有元素都做了相同的操作，O(n) -> O(1)
         同370。
    */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] flights = new int[n+1];

        Difference df = new Difference(flights);

        for(int i = 0; i < bookings.length; i++) {
            int start = bookings[i][0];
            int end = bookings[i][1];
            int val = bookings[i][2];
            df.increment(start, end ,val);
        }

        return df.result();
    }
}

// 差分数组工具类
class Difference_1109 {
    private int[] diff;

    public Difference_1109(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i-1];
        }
    }

    public void increment(int start, int end, int val) {
        diff[start] += val;
        if (end+1 < diff.length)
            diff[end+1] -= val;
    }

    public int[] result(){
        int[] res = new int[diff.length-1];
        res[0] = diff[1];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i-1] + diff[i+1];
        }
        return res;
    }
}