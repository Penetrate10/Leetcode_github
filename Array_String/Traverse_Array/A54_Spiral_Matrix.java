package Array_String.Traverse_Array;

import java.util.LinkedList;
import java.util.List;

public class A54_Spiral_Matrix {
    /*
    题目：螺旋遍历二维数组
    思路：按照右、下、左、上的顺序遍历数组，并使用四个变量圈定未遍历元素的边界。
         对于一维数组，常用双指针。
         对于二维数组，就可以用4指针圈定要处理的区域。
         详见：https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-48c1d/er-wei-shu-150fb/#%E7%9F%A9%E9%98%B5%E7%9A%84%E8%9E%BA%E6%97%8B%E9%81%8D%E5%8E%86
    */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 4指针
        int upper = 0;
        int lower = m-1;
        int left = 0;
        int right = n-1;

        List<Integer> nums = new LinkedList<>();

        while(nums.size() < m*n) {  // res.size() == m * n 则遍历完整个数组
            if(upper <= lower) {
                for(int i = left; i <= right; i++){
                    nums.add(matrix[upper][i]);
                }
                upper++;
            }

            if(left <= right) {
                for(int j = upper; j <= lower; j++){
                    nums.add(matrix[j][right]);
                }
                right--;
            }

            if(upper <= lower) {
                for(int i = right; i >= left; i--) {
                    nums.add(matrix[lower][i]);
                }
                lower--;;
            }

            if(left <= right) {
                for(int j = lower; j >= upper; j--){
                    nums.add(matrix[j][left]);
                }
                left++;
            }
        }

        return nums;
    }
}
