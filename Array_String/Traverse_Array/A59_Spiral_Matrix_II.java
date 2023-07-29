package Array_String.Traverse_Array;

public class A59_Spiral_Matrix_II {
    /*
    题目：螺旋生成二维数组
    思路：按照右、下、左、上的顺序遍历数组，并使用四个变量圈定未遍历元素的边界。
         对于一维数组，常用双指针。
         对于二维数组，就可以用4指针圈定要处理的区域。
         详见：https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-48c1d/er-wei-shu-150fb/#%E7%9F%A9%E9%98%B5%E7%9A%84%E8%9E%BA%E6%97%8B%E9%81%8D%E5%8E%86
         同54。
    */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int upper = 0;
        int lower = n-1;
        int left = 0;
        int right = n-1;
        int num = 1;

        while(num <= n*n) {
            if(upper <= lower) {
                for(int i = left; i <= right; i++) {
                    matrix[upper][i] = num++;
                }
                upper++;
            }

            if(left <= right) {
                for(int j = upper; j <= lower; j++){
                    matrix[j][right] = num++;
                }
                right--;
            }

            if(upper <= lower) {
                for(int i = right; i >= left; i--) {
                    matrix[lower][i] = num++;
                }
                lower--;;
            }

            if(left <= right) {
                for(int j = lower; j >= upper; j--){
                    matrix[j][left] = num++;
                }
                left++;
            }
        }

        return matrix;
    }
}
