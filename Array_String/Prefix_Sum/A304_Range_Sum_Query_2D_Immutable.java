package Array_String.Prefix_Sum;

public class A304_Range_Sum_Query_2D_Immutable {
    /*
    题目：前缀和数组：快速、频繁地计算一个索引区间内的元素之和
    思路：与303题相同。
         （在处理索引的+1/-1问题上，二维数组不好想象，此时画图最快）
    */

    // 前缀和数组
    private int[][] preSum;

    public A304_Range_Sum_Query_2D_Immutable(int[][] matrix) {
        preSum = new int[matrix.length+1][matrix[0].length+1];

        // 计算 matrix 的前缀和，只用遍历一次数组就可以得到前缀和数组
        for (int i = 1; i < preSum.length; i++) {
            for(int j = 1; j < preSum[0].length; j++) {
                preSum[i][j] = matrix[i-1][j-1] + preSum[i][j-1] + preSum[i-1][j] - preSum[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1] - preSum[row1][col2+1] - preSum[row2+1][col1] + preSum[row1][col1];
    }
}
