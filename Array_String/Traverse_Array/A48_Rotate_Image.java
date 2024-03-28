package Array_String.Traverse_Array;

public class A48_Rotate_Image {
    /*
    思路：把二维数组顺时针旋转 90 度 = 先把矩阵按照左上到右下的对角线进行反转 + 再反转每行每一行
         把二维数组逆时针旋转 90 度 = 先把矩阵按照右上到左下的对角线进行反转 + 再反转每行每一行
         画图！
         详见：https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-48c1d/er-wei-shu-150fb/#%E9%A1%BA-%E9%80%86%E6%97%B6%E9%92%88%E6%97%8B%E8%BD%AC%E7%9F%A9%E9%98%B5
    */

    // 按照左上到右下的对角线进行镜像对称 = 求矩阵转置 A[i][j] == A'[j][i]
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i + 1; j < matrix[0].length; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            reverse(matrix[i]);
        }
    }

    // 双指针反转一维矩阵
    void reverse(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
